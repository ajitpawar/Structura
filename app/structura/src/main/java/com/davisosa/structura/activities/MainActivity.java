package com.davisosa.structura.activities;

import android.os.Bundle;

import com.davisosa.structura.R;
import com.davisosa.structura.activities.base.BaseActivity;

public class MainActivity extends BaseActivity {
    @Override
    protected int getSelfDrawerItem() {
        return DRAWER_ITEM_GONE;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle(R.string.landing);
    }
}