package com.davisosa.structura.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.davisosa.structura.R;
import com.davisosa.structura.activities.base.BaseActivity;
import com.davisosa.structura.adapters.MyFragmentPagerAdapter;
import com.davisosa.structura.widget.SlidingTabLayout;

public class MainActivity extends BaseActivity {
    @Override
    protected int getSelfDrawerItem() {
        return DRAWER_ITEM_SEC1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = getActionBarToolbar();
        toolbar.setTitle(R.string.title_section1);

        overridePendingTransition(0, 0);

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),
                MainActivity.this));

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