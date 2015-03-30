package com.davisosa.structura.activities.base;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.LayoutRes;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.davisosa.structura.R;
import com.davisosa.structura.activities.BSTActivity;
import com.davisosa.structura.activities.LLActivity;
import com.davisosa.structura.util.OverviewStyler;
import com.davisosa.structura.util.PrefUtils;
import com.davisosa.structura.util.UIUtils;
import com.mikepenz.aboutlibraries.Libs;

import java.util.ArrayList;
import java.util.List;

/**
 * A base {@link android.app.Activity} that handles common functionality in the app.
 */
public abstract class BaseActivity extends ActionBarActivity
        implements SharedPreferences.OnSharedPreferenceChangeListener {
    /* Symbols for navigation drawer items (indices must correspond to RES_IDS_DRAWER_TITLE).
     * This is a list of all possible items, which are not necessarily present,
     * in the navigation drawer. */
    protected static final int DRAWER_ITEM_LL = 0;
    protected static final int DRAWER_ITEM_BST = 1;
    protected static final int DRAWER_ITEM_SETTINGS = 2;
    protected static final int DRAWER_ITEM_ABOUT = 3;
    protected static final int DRAWER_ITEM_INVALID = -1;
    protected static final int DRAWER_ITEM_SEPARATOR = -2;
    protected static final int DRAWER_ITEM_SEPARATOR_SPECIAL = -3;
    protected static final int DRAWER_ITEM_GONE = -4;

    // Titles for navigation drawer items (indices must correspond to DRAWER_ITEM_*)
    private static final int[] RES_IDS_DRAWER_TITLE = new int[]{
            R.string.title_linked_list,
            R.string.title_bst,
            R.string.title_settings,
            R.string.title_about
    };

    // Icons for navigation drawer items (indices must correspond to RES_IDS_DRAWER_TITLE)
    private static final int[] RES_IDS_DRAWER_ICON = new int[]{
            0,    // Section 1
            0,    // Section 2
            R.drawable.ic_settings,
            R.drawable.ic_about
    };

    // Delay to launch navigation drawer item, to allow close animation to play
    private static final int DRAWER_LAUNCH_DELAY = 250;

    // Navigation drawer
    private DrawerLayout mDrawerLayout;

    private ViewGroup mDrawerItemsListContainer;

    /**
     * Helper component that ties the action bar to the navigation drawer.
     */
    private ActionBarDrawerToggleWrapper mDrawerToggle;

    private Handler mHandler;

    // List of navigation drawer items that were actually added to the drawer, in order
    private List<Integer> mDrawerItems = new ArrayList<>();

    // Views that correspond to each navigation drawer item; default null
    private View[] mDrawerItemViews = null;

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

    protected boolean isDrawerOpen() {
        return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(Gravity.START);
    }

    protected void closeDrawer() {
        if (mDrawerLayout != null) {
            mDrawerLayout.closeDrawer(Gravity.START);
        }
    }

    /**
     * Populates the navigation drawer with the appropriate items.
     */
    private void populateDrawer() {
        mDrawerItems.clear();

        mDrawerItems.add(DRAWER_ITEM_LL);
        mDrawerItems.add(DRAWER_ITEM_BST);

        mDrawerItems.add(DRAWER_ITEM_SEPARATOR_SPECIAL);
        mDrawerItems.add(DRAWER_ITEM_SETTINGS);
        mDrawerItems.add(DRAWER_ITEM_ABOUT);

        createDrawerItems();
    }

    @Override
    public void onBackPressed() {
        if (isDrawerOpen()) {
            closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    private void createDrawerItems() {
        mDrawerItemsListContainer = (ViewGroup) findViewById(R.id.drawer_items_list);
        if (mDrawerItemsListContainer == null) {
            return;
        }

        mDrawerItemViews = new View[mDrawerItems.size()];
        mDrawerItemsListContainer.removeAllViews();

        int i = 0;
        for (int itemId : mDrawerItems) {
            mDrawerItemViews[i] = createDrawerItem(itemId, mDrawerItemsListContainer);
            mDrawerItemsListContainer.addView(mDrawerItemViews[i]);
            i++;
        }
    }

    /**
     * Sets the given navigation drawer item's appearance to the selected state.
     *
     * @param itemId selected navigation drawer item
     */
    private void setSelectedDrawerItem(int itemId) {
        if (mDrawerItemViews != null) {
            int numItems = mDrawerItems.size();
            for (int i = 0; i < mDrawerItemViews.length && i < numItems; i++) {
                int thisItemId = mDrawerItems.get(i);
                formatDrawerItem(mDrawerItemViews[i], thisItemId, itemId == thisItemId);
            }
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
    protected int getSelfDrawerItem() {
        return DRAWER_ITEM_INVALID;
    }

    /**
     * Sets up the navigation drawer as appropriate.
     */
    private void setupNavigationDrawer() {
        // Selected navigation drawer item
        int selfItem = getSelfDrawerItem();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (mDrawerLayout == null) {
            return;
        }
        mDrawerLayout.setStatusBarBackgroundColor(
                getResources().getColor(R.color.theme_primary_dark));
        ScrollView drawer = (ScrollView) mDrawerLayout.findViewById(R.id.drawer);
        if (selfItem == DRAWER_ITEM_INVALID) {
            // Don't show a navigation drawer.
            if (drawer != null) {
                ((ViewGroup) drawer.getParent()).removeView(drawer);
            }
            mDrawerLayout = null;
            return;
        }

        /* ActionBarDrawerToggle ties together the the proper interactions
         * between the navigation drawer and the action bar app icon. */
        mDrawerToggle = setupDrawerToggle(mActionBarToolbar, mDrawerLayout,
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerClosed(View drawerView) {
                        invalidateOptionsMenu();    // Calls onPrepareOptionsMenu()
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        invalidateOptionsMenu();    // Calls onPrepareOptionsMenu()
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                    }

                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                    }
                });

        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, Gravity.START);

        // Populate the navigation drawer with the correct items.
        populateDrawer();

        mDrawerToggle.syncState();

        // First run of the app starts with the navigation drawer open.
        if (!PrefUtils.isWelcomeDone(this)) {
            PrefUtils.markWelcomeDone(this);
            mDrawerLayout.openDrawer(Gravity.START);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (mDrawerToggle != null) {
            mDrawerToggle.onConfigurationChanged(newConfig);
        }
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        getActionBarToolbar();
    }

    public void onDrawerItemClicked(final int itemId) {
        if (itemId == getSelfDrawerItem()) {
            mDrawerLayout.closeDrawer(Gravity.START);
            return;
        }

        if (isSpecialItem(itemId)) {
            goToDrawerItem(itemId);
        } else {
            // Launch the target activity after a short delay, to allow the close animation to play.
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    goToDrawerItem(itemId);
                }
            }, DRAWER_LAUNCH_DELAY);

            // Change the active item on the list so the user can see the item changed.
            setSelectedDrawerItem(itemId);
        }

        mDrawerLayout.closeDrawer(Gravity.START);
    }

    protected ActionBarDrawerToggleWrapper setupDrawerToggle(
            Toolbar toolbar, DrawerLayout drawerLayout,
            final DrawerLayout.DrawerListener drawerListener) {
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                drawerLayout,          /* DrawerLayout object */
                toolbar,               /* action bar Toolbar */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
        ) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                drawerListener.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                drawerListener.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                super.onDrawerStateChanged(newState);
                drawerListener.onDrawerStateChanged(newState);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                drawerListener.onDrawerSlide(drawerView, slideOffset);
            }
        };

        drawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(Gravity.START);
            }
        });

        drawerLayout.setDrawerListener(drawerToggle);
        return new ActionBarDrawerToggleWrapper(drawerToggle);
    }

    private boolean isSpecialItem(int itemId) {
        return itemId == DRAWER_ITEM_SETTINGS || itemId == DRAWER_ITEM_ABOUT;
    }

    /**
     * Navigates to selected drawer item.
     *
     * @param item selected navigation drawer item
     */
    public void goToDrawerItem(int item) {
        switch (item) {
            case DRAWER_ITEM_LL:
                UIUtils.startActivityWithTransition(this, new Intent(this, LLActivity.class));
                finish();
                break;
            case DRAWER_ITEM_BST:
                UIUtils.startActivityWithTransition(this, new Intent(this, BSTActivity.class));
                finish();
                break;
            case DRAWER_ITEM_SETTINGS:
                // TODO: startActivity
                break;
            case DRAWER_ITEM_ABOUT:
                new Libs.Builder()
                        .withFields(R.string.class.getFields())
                        .withLibraries("materialdesignicons", "mdiexpanded", "slidingtabs",
                                "materialdialogs", "snackbar")
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
        setupNavigationDrawer();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (mDrawerToggle != null && mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (id) {
            case R.id.action_settings:
                // TODO
                break;
            case R.id.action_example:
                // TODO
                break;
        }
        return super.onOptionsItemSelected(item);
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

    private View createDrawerItem(final int itemId, ViewGroup container) {
        boolean selected = getSelfDrawerItem() == itemId;

        int layout;
        if (itemId == DRAWER_ITEM_SEPARATOR) {
            layout = R.layout.drawer_separator;
        } else if (itemId == DRAWER_ITEM_SEPARATOR_SPECIAL) {
            layout = R.layout.drawer_separator;
        } else {
            layout = R.layout.drawer_item;
        }
        View view = getLayoutInflater().inflate(layout, container, false);

        if (isSeparator(itemId)) {
            // We're done.
            UIUtils.setAccessibilityIgnore(view);
            return view;
        }

        ImageView iconView = (ImageView) view.findViewById(R.id.icon);
        TextView titleView = (TextView) view.findViewById(R.id.title);
        int iconId = itemId >= 0 && itemId < RES_IDS_DRAWER_ICON.length ?
                RES_IDS_DRAWER_ICON[itemId] : 0;
        int titleId = itemId >= 0 && itemId < RES_IDS_DRAWER_TITLE.length ?
                RES_IDS_DRAWER_TITLE[itemId] : 0;

        // Set icon and text.
        if (iconId > 0) {
            iconView.setVisibility(View.VISIBLE);
            iconView.setImageResource(iconId);
        } else {
            iconView.setVisibility(View.INVISIBLE);
        }
        titleView.setText(getString(titleId));

        formatDrawerItem(view, itemId, selected);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDrawerItemClicked(itemId);
            }
        });

        return view;
    }

    private boolean isSeparator(int itemId) {
        return itemId == DRAWER_ITEM_SEPARATOR || itemId == DRAWER_ITEM_SEPARATOR_SPECIAL;
    }

    private void formatDrawerItem(View view, int itemId, boolean selected) {
        if (isSeparator(itemId)) {
            return;    // N/A
        }

        ImageView iconView = (ImageView) view.findViewById(R.id.icon);
        TextView titleView = (TextView) view.findViewById(R.id.title);

        if (selected) {
            view.setBackgroundResource(R.drawable.drawer_item_bg_selected);
        }

        // Configure its appearance according to whether or not it's selected.
        Resources res = getResources();
        titleView.setTextColor(selected ?
                res.getColor(R.color.drawer_text_color_selected) :
                res.getColor(R.color.drawer_text_color));
        iconView.setColorFilter(selected ?
                res.getColor(R.color.drawer_icon_tint_selected) :
                res.getColor(R.color.drawer_icon_tint), PorterDuff.Mode.SRC_IN);
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
        if (mDrawerLayout != null) {
            mDrawerLayout.setStatusBarBackgroundColor(mNormalStatusBarColor);
        }
    }

    public class ActionBarDrawerToggleWrapper {
        private ActionBarDrawerToggle mDrawerToggle;

        public ActionBarDrawerToggleWrapper(ActionBarDrawerToggle drawerToggle) {
            mDrawerToggle = drawerToggle;
        }

        public void syncState() {
            if (mDrawerToggle != null) {
                mDrawerToggle.syncState();
            }
        }

        public void onConfigurationChanged(Configuration newConfig) {
            // Forward the new configuration to the drawer toggle component.
            if (mDrawerToggle != null) {
                mDrawerToggle.onConfigurationChanged(newConfig);
            }
        }

        public boolean onOptionsItemSelected(MenuItem item) {
            // Toggle navigation drawer on selecting action bar app icon/title.
            return mDrawerToggle != null && mDrawerToggle.onOptionsItemSelected(item);
        }
    }
}