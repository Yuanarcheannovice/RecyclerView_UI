package com.xz.ui;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.TextUtils;

/**
 * Created by Administrator on 2018/8/30.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    final String[] TITLES;

    public ViewPagerAdapter(FragmentManager fm, String... titles) {
        super(fm);
        TITLES = titles;
    }

    @Override
    public Fragment getItem(int position) {
        if (TextUtils.equals(TITLES[position], "待付款")) {
            return WaitPayFragment.newInstance();
        } else {
            return CommonlyFragment.newInstance(TITLES[position]);
        }

    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }
}
