package com.davisosa.structura.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.davisosa.structura.R;
import com.davisosa.structura.activities.base.BaseActivity;
import com.davisosa.structura.adapters.BSTPagerAdapter;
import com.davisosa.structura.fragments.BSTPlayFragment;
import com.davisosa.structura.widget.SlidingTabLayout;

public class BSTActivity extends BaseActivity
        implements BSTPlayFragment.OnFragmentInteractionListener {
    private ViewPager mViewPager;
    private SlidingTabLayout mSlidingTabLayout;

    @Override
    protected int getSelfDrawerItem() { return DRAWER_ITEM_BST; }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_bst);

        getSupportActionBar().setTitle(R.string.title_bst);
        overridePendingTransition(0, 0);

        // Get the ViewPager and set its PagerAdapter so that it can display items.
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new BSTPagerAdapter(getSupportFragmentManager(),
                BSTActivity.this));

        // Give the SlidingTabLayout the ViewPager.
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);

        // Set a custom tab view.
        mSlidingTabLayout.setCustomTabView(R.layout.tab_view, R.id.tab_text);

        // Set indicator colors.
        mSlidingTabLayout.setSelectedIndicatorColors(
                getResources().getColor(R.color.tab_indicator_color));

        // Center the tabs in the layout.
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setViewPager(mViewPager);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }
}