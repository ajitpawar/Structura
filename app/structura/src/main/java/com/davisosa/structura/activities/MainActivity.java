package com.davisosa.structura.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import com.davisosa.structura.R;
import com.davisosa.structura.activities.base.BaseActivity;
import com.davisosa.structura.adapters.MyFragmentPagerAdapter;
import com.davisosa.structura.widget.SlidingTabLayout;


public class MainActivity extends BaseActivity {
    @Override
    protected int getSelfDrawerItem() {
        return DRAWER_ITEM_LANDING;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle(R.string.landing);

        overridePendingTransition(0, 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}