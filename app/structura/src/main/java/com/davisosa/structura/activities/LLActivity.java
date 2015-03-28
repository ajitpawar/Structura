package com.davisosa.structura.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.davisosa.structura.R;
import com.davisosa.structura.activities.base.BaseActivity;
import com.davisosa.structura.adapters.LLPagerAdapter;
import com.davisosa.structura.fragments.LLPlayFragment;
import com.davisosa.structura.widget.SlidingTabLayout;

public class LLActivity extends BaseActivity
        implements LLPlayFragment.OnFragmentInteractionListener {
    private ViewPager mViewPager;
    private SlidingTabLayout mSlidingTabLayout;

    @Override
    protected int getSelfDrawerItem() {
        return DRAWER_ITEM_LL;
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_linked_list);

        getSupportActionBar().setTitle(R.string.title_linked_list);

        // Get the ViewPager and set its PagerAdapter so that it can display items.
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new LLPagerAdapter(getSupportFragmentManager(),
                LLActivity.this));

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