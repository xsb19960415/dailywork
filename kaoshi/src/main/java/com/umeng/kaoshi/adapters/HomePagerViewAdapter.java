package com.umeng.kaoshi.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class HomePagerViewAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments=new ArrayList<>();
    public HomePagerViewAdapter(FragmentManager fm,ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments.addAll(fragments);
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
