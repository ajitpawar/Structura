package com.davisosa.structura.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.davisosa.structura.R;
import com.davisosa.structura.fragments.BSTPlayFragment;
import com.davisosa.structura.fragments.BSTQuizFragment;
import com.davisosa.structura.fragments.BSTSummaryFragment;
import com.davisosa.structura.fragments.LLQuizFragment;

import timber.log.Timber;

public class BSTPagerAdapter extends FragmentPagerAdapter {
    // Tab positions
    private static final int PLAY = 0;
    private static final int SUMMARY = 1;
    private static final int QUIZ = 2;

    private static final int PAGE_COUNT = 3;
    private Context mContext;

    public BSTPagerAdapter(FragmentManager manager, Context context) {
        super(manager);
        mContext = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case PLAY:
                Timber.d("Creating Play fragment");
                return BSTPlayFragment.newInstance();
            case SUMMARY:
                Timber.d("Creating Summary fragment");
                return BSTSummaryFragment.newInstance(position + 1);
            case QUIZ:
                Timber.d("Creating fragment #" + position + 1);
                return BSTQuizFragment.newInstance(position + 2);
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position.
        switch (position) {
            case PLAY:
                return mContext.getResources().getString(R.string.title_play);
            case SUMMARY:
                return mContext.getResources().getString(R.string.title_summary);
            case QUIZ:
                return mContext.getResources().getString(R.string.title_quiz);
            default:
                return null;
        }
    }
}