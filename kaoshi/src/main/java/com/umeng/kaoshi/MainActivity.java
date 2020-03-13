package com.umeng.kaoshi;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.umeng.kaoshi.adapters.HomePagerViewAdapter;
import com.umeng.kaoshi.fragments.HomeFragment;
import com.umeng.kaoshi.fragments.OterFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewpager;
    private TabLayout mTablayout;
    private HomePagerViewAdapter homePagerViewAdapter;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mTablayout = (TabLayout) findViewById(R.id.tablayout);

        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new OterFragment());
        homePagerViewAdapter = new HomePagerViewAdapter(getSupportFragmentManager(),fragments);
        mViewpager.setAdapter(homePagerViewAdapter);
        mTablayout.setupWithViewPager(mViewpager);
        mTablayout.getTabAt(0).setText("้首页").setIcon(R.drawable.myselect);
        mTablayout.getTabAt(1).setText("我的").setIcon(R.drawable.myselect);

    }
}
