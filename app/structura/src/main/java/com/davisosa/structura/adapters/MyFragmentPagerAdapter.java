package com.davisosa.structura.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.davisosa.structura.R;
import com.davisosa.structura.fragments.PageFragment;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    //private String tabTitles[] = new String[] { "Play", "Summary", "Quiz" };
    private Context context;

    public MyFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position + 1);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position){
            case 0:
                return context.getResources().getString(R.string.title_tab1);
            case 1:
                return context.getResources().getString(R.string.title_tab2);
            case 2:
                return context.getResources().getString(R.string.title_tab3);
        }

        return null;
    }
}

