package com.xz.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }


    private void initView() {
        mTabLayout = findViewById(R.id.am_tl);
        mViewPager = findViewById(R.id.am_vp);
    }

    private void initData() {
        String[] titls = {"全部", "待付款", "待发货", "待评价", "退换货"};
        for (String t : titls) {
            mTabLayout.addTab(mTabLayout.newTab().setText(t));
        }
        //
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),titls));

    }
}
