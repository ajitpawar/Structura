package com.davisosa.structura.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davisosa.structura.R;
import com.davisosa.structura.activities.base.BaseActivity;

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}