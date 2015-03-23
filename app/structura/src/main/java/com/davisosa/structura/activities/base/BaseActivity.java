package com.davisosa.structura.activities.base;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.LayoutRes;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;

import com.davisosa.structura.R;
import com.davisosa.structura.activities.LLActivity;
import com.davisosa.structura.activities.MainActivity;
import com.davisosa.structura.util.OverviewStyler;
import com.davisosa.structura.util.PrefUtils;
import com.davisosa.structura.util.UIUtils;
import com.mikepenz.aboutlibraries.Libs;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

import timber.log.Timber;

/**
 * A base {@link android.app.Activity} that handles common functionality in the app.
 */
public abstract class BaseActivity extends ActionBarActivity
        implements SharedPreferences.OnSharedPreferenceChangeListener {
    /* Symbols for navigation drawer items.
     * This is a list of all possible items, which are not necessarily present,
     * in the navigation drawer. */
    protected static final int DRAWER_ITEM_LL = 1;
    protected static final int DRAWER_ITEM_SEC2 = 2;
    protected static final int DRAWER_ITEM_SETTINGS = 3;
    protected static final int DRAWER_ITEM_ABOUT = 4;
    protected static final int DRAWER_ITEM_INVALID = -1;
    protected static final int DRAWER_ITEM_GONE = -4;

    // Delay to launch navigation drawer item, to allow close animation to play
    private static final int DRAWER_LAUNCH_DELAY = 250;

    /* Fade-in and fade-out durations for the main content when switching between
     * different activities of the app through the navigation drawer */
    private static final int MAIN_CONTENT_FADEOUT_DURATION = 150;
    private static final int MAIN_CONTENT_FADEIN_DURATION = 250;

    // Navigation drawer
    private Drawer.Result mDrawerResult;

    private Handler mHandler;

    // Primary toolbar and drawer toggle
    private Toolbar mActionBarToolbar;

    private int mThemedStatusBarColor;
    private int mNormalStatusBarColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OverviewStyler.styleOverviewEntry(this);
        PrefUtils.registerOnSharedPreferenceChangeListener(this, this);

        mHandler = new Handler();
        mThemedStatusBarColor = getResources().getColor(R.color.theme_primary_dark);
        mNormalStatusBarColor = mThemedStatusBarColor;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerResult != null && mDrawerResult.isDrawerOpen()) {
            mDrawerResult.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    /**
     * Returns the navigation drawer item that corresponds to this {@link android.app.Activity}.
     * <br>
     * Subclasses of {@link com.davisosa.structura.activities.base.BaseActivity} override
     * this to indicate what navigation drawer item corresponds to them.
     *
     * @return {@code DRAWER_ITEM_INVALID} to mean that this {@link android.app.Activity} should
     * not have a navigation drawer.
     */
    protected int getSelfDrawerItemId() {
        return DRAWER_ITEM_INVALID;
    }

    /**
     * Sets up the navigation drawer as appropriate.
     *
     * @param savedInstanceState saved instance state
     */
    private void setupNavigationDrawer(Bundle savedInstanceState) {
        int selfItemId = getSelfDrawerItemId();
        if (selfItemId == DRAWER_ITEM_INVALID) {
            // Don't show a navigation drawer.
            return;
        }

        // Create the navigation drawer.
        mDrawerResult = new Drawer()
                .withActivity(this)
                .withToolbar(mActionBarToolbar)
                .addDrawerItems(
                        new PrimaryDrawerItem()
                                .withName(R.string.title_linked_list)
                                .withIcon(android.R.color.transparent)
                                .withIdentifier(DRAWER_ITEM_LL),
                        new PrimaryDrawerItem()
                                .withName(R.string.title_section2)
                                .withIcon(android.R.color.transparent)
                                .withIdentifier(DRAWER_ITEM_SEC2),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem()
                                .withName(R.string.title_about)
                                .withIcon(R.drawable.ic_about)
                                .withTintSelectedIcon(true)
                                .withIdentifier(DRAWER_ITEM_ABOUT)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int pos,
                                            long id, IDrawerItem drawerItem) {
                        if (drawerItem != null && drawerItem instanceof Nameable) {
                            getSupportActionBar().setTitle(((Nameable) drawerItem).getNameRes());
                            onDrawerItemClick(drawerItem.getIdentifier());
                        }
                    }
                })
                .withSavedInstance(savedInstanceState)
                .build();

        // Set the active selection if this is a new instance.
        if (savedInstanceState == null) {
            if (selfItemId > 0) {
                mDrawerResult.setSelectionByIdentifier(selfItemId, false);
            }
        }

        // First run of the app starts with the navigation drawer open.
        if (!PrefUtils.isWelcomeDone(this)) {
            PrefUtils.markWelcomeDone(this);
            mDrawerResult.openDrawer();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState = mDrawerResult.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        getActionBarToolbar();
    }

    public void onDrawerItemClick(final int itemId) {
        if (itemId == getSelfDrawerItemId()) {
            mDrawerResult.closeDrawer();
            return;
        }

        // Change the active item on the list so the user can see the item changed.
        mDrawerResult.setSelectionByIdentifier(itemId, false);
        mDrawerResult.closeDrawer();

        // Fade out the main content.
        View mainContent = findViewById(R.id.main_content);
        if (mainContent != null) {
            mainContent.animate().alpha(0).setDuration(MAIN_CONTENT_FADEOUT_DURATION);
        }

        goToDrawerItem(itemId);

/*
        if (isSpecialItem(itemId)) {
        } else {
            // Launch the target activity after a short delay, to allow the close animation to play.
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    goToDrawerItem(itemId);
                }
            }, DRAWER_LAUNCH_DELAY);

        }
*/
    }

    private boolean isSpecialItem(int itemId) {
        return itemId == DRAWER_ITEM_SETTINGS || itemId == DRAWER_ITEM_ABOUT;
    }

    /**
     * Navigates to the selected drawer item.
     *
     * @param itemId selected navigation drawer item
     */
    public void goToDrawerItem(int itemId) {
        switch (itemId) {
            case DRAWER_ITEM_LL:
                UIUtils.startActivityWithTransition(this, new Intent(this, LLActivity.class),
                        mActionBarToolbar, "actionbar");
                finish();
                break;
            case DRAWER_ITEM_SEC2:
                // TODO: new Activity
                UIUtils.startActivityWithTransition(this, new Intent(this, MainActivity.class),
                        mActionBarToolbar, "actionbar");
                finish();
                break;
            case DRAWER_ITEM_SETTINGS:
                // TODO: startActivity
                break;
            case DRAWER_ITEM_ABOUT:
                new Libs.Builder()
                        .withFields(R.string.class.getFields())
                        .withLibraries("materialdesignicons", "mdiexpanded", "slidingtabs")
                        .withExcludedLibraries("materialicons")
                        .withLicenseShown(true)
                        .withVersionShown(false)
                        .withActivityTitle(getResources().getString(R.string.title_about))
                        .withActivityTheme(R.style.Theme_Structura_LibsActivity)
                        .start(this);
                break;
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setupNavigationDrawer(savedInstanceState);

        View mainContent = findViewById(R.id.main_content);
        if (mainContent != null) {
            mainContent.setAlpha(0);
            mainContent.animate().alpha(1).setDuration(MAIN_CONTENT_FADEIN_DURATION);
        } else {
            Timber.w("No view with ID main_content to fade in.");
        }
    }

    protected Toolbar getActionBarToolbar() {
        if (mActionBarToolbar == null) {
            mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
            if (mActionBarToolbar != null) {
                setSupportActionBar(mActionBarToolbar);
            }
        }
        return mActionBarToolbar;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PrefUtils.unregisterOnSharedPreferenceChangeListener(this, this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
    }

    public int getThemedStatusBarColor() {
        return mThemedStatusBarColor;
    }

    public void setNormalStatusBarColor(int color) {
        mNormalStatusBarColor = color;
    }
}