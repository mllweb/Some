package com.mllweb.some.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 2016/7/13.
 */
public class MainTabPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments = new ArrayList<>();

    public MainTabPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        if (fragments != null) {
            mFragments = fragments;
        }
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
