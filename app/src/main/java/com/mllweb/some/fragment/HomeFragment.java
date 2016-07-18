package com.mllweb.some.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mllweb.model.bean.TabBean;
import com.mllweb.presenter.DAL.HomeFragPresenter;
import com.mllweb.presenter.IDAL.IHomeFragPresenter;
import com.mllweb.presenter.IVIEW.HomeFragView;
import com.mllweb.some.BaseFragment;
import com.mllweb.some.R;
import com.mllweb.some.activity.HomeTabConfigActivity;
import com.mllweb.some.adapter.HomeTabPagerAdapter;
import com.mllweb.some.widget.ScrollViewPager;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * Created by Android on 2016/7/13.
 */
public class HomeFragment extends BaseFragment implements HomeFragView {
    @InjectView(R.id.tabPager)
    ScrollViewPager mTabPager;
    @InjectView(R.id.tabScrollView)
    HorizontalScrollView mTabScrollView;
    @InjectView(R.id.tabLayout)
    LinearLayout mTabLayout;
    @InjectView(R.id.tabConfig)
    RelativeLayout mTabConfig;
    @InjectView(R.id.tabLine)
    View mTabLine;
    private HomeTabPagerAdapter mTabAdapter;
    private List<Fragment> mFragments = new ArrayList<>();
    private List<TextView> mTabs = new ArrayList<>();
    private IHomeFragPresenter mPresenter;

    @Override
    protected int onLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void onPrepare() {
        mPresenter.onTabLayout();
    }

    @Override
    protected void onPresenter() {
        mPresenter = new HomeFragPresenter(this);
    }

    @Override
    protected void onEvent() {
        mTabConfig.setOnClickListener((v) -> {
            Intent intent = new Intent(getActivity(), HomeTabConfigActivity.class);
            startActivity(intent);
        });
        mTabPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mPresenter.setTabPosition(position, mTabs.size());
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mTabLine.getLayoutParams();
                params.leftMargin = (int) (params.width * position + params.width * positionOffset);
                mTabLine.setLayoutParams(params);
                if (position >= 2) {
                    int i = (int) (params.width * (position - 2) + params.width * positionOffset);
                    mTabScrollView.scrollTo(i, 0);
                } else {
                    mTabScrollView.scrollTo(0, 0);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void configTabLayout(List<TabBean> tabs) {
        mTabLayout.removeAllViews();
        mFragments.clear();
        for (int i = 0; i < tabs.size(); i++) {
            TabBean tab = tabs.get(i);
            TextView tv = new TextView(getContext());
            tv.setGravity(Gravity.CENTER);
            if (i == 0)
                tv.setTextColor(0xFFFFFFFF);
            else
                tv.setTextColor(0x66FFFFFF);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, 45);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(200, ViewGroup.LayoutParams.MATCH_PARENT);
            tv.setLayoutParams(params);
            tv.setText(tab.getTabName());
            final int position = i;
            tv.setOnClickListener((v) -> mTabPager.setCurrentItem(position));
            AutoUtils.auto(tv);
            AutoUtils.autoTextSize(tv);
            mTabLayout.addView(tv);
            mTabs.add(tv);
            Fragment fragment = new HomeTabFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("tab", tab);
            fragment.setArguments(bundle);
            mFragments.add(fragment);
        }
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mTabLine.getLayoutParams();
        params.width = 200;
        mTabLine.setLayoutParams(params);
        AutoUtils.auto(mTabLine);
        mTabAdapter = new HomeTabPagerAdapter(getChildFragmentManager(), mFragments);
        mTabPager.setAdapter(mTabAdapter);
        mTabPager.setOffscreenPageLimit(tabs.size());
        mTabPager.setScroll(true);
    }

    @Override
    public void setSelect(int position) {
        mTabs.get(position).setTextColor(0xFFFFFFFF);
    }

    @Override
    public void setUnSelect(int position) {
        mTabs.get(position).setTextColor(0x66FFFFFF);
    }
}
