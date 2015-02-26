package com.davisosa.structura.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import com.davisosa.structura.R;
import com.davisosa.structura.activities.base.BaseActivity;
import com.davisosa.structura.adapters.MyFragmentPagerAdapter;
import com.davisosa.structura.widget.SlidingTabLayout;

/**
 * Created by ajit on 2/26/2015.
 */
public class LinkedListActivity extends BaseActivity {

    @Override
    protected int getSelfDrawerItem() {
        return DRAWER_ITEM_LANDING;
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_linkedlist);

        // getSupportActionBar().setTitle(R.string.landing);
        // overridePendingTransition(0, 0);

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),
                LinkedListActivity.this));

        // Give the SlidingTabLayout the ViewPager
        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);

        // Center the tabs in the layout
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
