package com.mllweb.some.activity;

import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mllweb.presenter.DAL.MainPresenter;
import com.mllweb.presenter.IDAL.IMainPresenter;
import com.mllweb.presenter.IVIEW.MainView;
import com.mllweb.some.BaseActivity;
import com.mllweb.some.R;
import com.mllweb.some.adapter.MainTabPagerAdapter;
import com.mllweb.some.fragment.FindFragment;
import com.mllweb.some.fragment.FollowFragment;
import com.mllweb.some.fragment.HomeFragment;
import com.mllweb.some.fragment.MineFragment;
import com.mllweb.some.widget.ScrollViewPager;

import java.util.LinkedList;

import butterknife.InjectView;

public class MainActivity extends BaseActivity implements MainView {
    @InjectView(R.id.homeText)
    TextView mHomeText;
    @InjectView(R.id.followText)
    TextView mFollowText;
    @InjectView(R.id.findText)
    TextView mFindText;
    @InjectView(R.id.mineText)
    TextView mMineText;
    @InjectView(R.id.homeIcon)
    ImageView mHomeIcon;
    @InjectView(R.id.followIcon)
    ImageView mFollowIcon;
    @InjectView(R.id.findIcon)
    ImageView mFindIcon;
    @InjectView(R.id.mineIcon)
    ImageView mMineIcon;
    @InjectView(R.id.tabPager)
    ScrollViewPager mTabPager;
    @InjectView(R.id.homeLayout)
    LinearLayout mHomeLayout;
    @InjectView(R.id.followLayout)
    LinearLayout mFollowLayout;
    @InjectView(R.id.findLayout)
    LinearLayout mFindLayout;
    @InjectView(R.id.mineLayout)
    LinearLayout mMineLayout;
    private IMainPresenter mPresenter;
    private MainTabPagerAdapter mTabAdapter;
    private LinkedList<TextView> mTabTexts = new LinkedList<>();
    private LinkedList<ImageView> mTabIcons = new LinkedList<>();
    private LinkedList<Fragment> mFragments = new LinkedList<>();
    //未选中//选中
    private int[] mTabTextColorArray = new int[]{0xFF999999, 0xFFFF0000};
    //未选中//选中
    private int[] mTabIcomArray = new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
private final int tabSize=4;

    @Override
    protected int onLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onPrepare() {
        setTabText();
        setTabIcon();
        setFragment();
        mTabAdapter = new MainTabPagerAdapter(getSupportFragmentManager(), mFragments);
        mTabPager.setAdapter(mTabAdapter);
        mTabPager.setOffscreenPageLimit(tabSize);
        mPresenter.setTabPosition(0,tabSize);
    }

    @Override
    protected void onPresenter() {
        mPresenter = new MainPresenter(this);
    }

    @Override
    protected void onEvent() {
        mHomeLayout.setOnClickListener((v) -> mPresenter.setTabPosition(0,tabSize));
        mFollowLayout.setOnClickListener((v) -> mPresenter.setTabPosition(1,tabSize));
        mFindLayout.setOnClickListener((v) -> mPresenter.setTabPosition(2,tabSize));
        mMineLayout.setOnClickListener((v) -> mPresenter.setTabPosition(3,tabSize));
    }


    @Override
    public void setSelect(int position) {
        mTabTexts.get(position).setTextColor(mTabTextColorArray[1]);
        mTabIcons.get(position).setImageResource(mTabIcomArray[position + tabSize]);
        mTabPager.setCurrentItem(position, false);
    }

    @Override
    public void setUnSelect(int position) {
        mTabTexts.get(position).setTextColor(mTabTextColorArray[0]);
        mTabIcons.get(position).setImageResource(mTabIcomArray[position]);
    }

    private void setTabText() {
        mTabTexts.add(mHomeText);
        mTabTexts.add(mFollowText);
        mTabTexts.add(mFindText);
        mTabTexts.add(mMineText);
    }

    private void setTabIcon() {
        mTabIcons.add(mHomeIcon);
        mTabIcons.add(mFollowIcon);
        mTabIcons.add(mFindIcon);
        mTabIcons.add(mMineIcon);
    }

    private void setFragment() {
        mFragments.add(new HomeFragment());
        mFragments.add(new FollowFragment());
        mFragments.add(new FindFragment());
        mFragments.add(new MineFragment());
    }
}
