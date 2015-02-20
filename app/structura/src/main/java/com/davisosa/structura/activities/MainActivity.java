package com.davisosa.structura.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ImageView;

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
        //toolbar.setTitle(R.string.title_section1); //TODO: set this to a landing page tag

        overridePendingTransition(0, 0);

        final TextView welText = (TextView) findViewById(R.id.landingText);
        final ImageView welImg = (ImageView) findViewById(R.id.landingImage);

        welText.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.slide_in_left));
        welImg.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.slide_in_left));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}