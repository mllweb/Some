package com.mllweb.some.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mllweb.some.BaseActivity;
import com.mllweb.some.R;
import com.mllweb.some.adapter.MainTabPagerAdapter;
import com.mllweb.some.fragment.FindFragment;
import com.mllweb.some.fragment.FollowFragment;
import com.mllweb.some.fragment.HomeFragment;
import com.mllweb.some.fragment.MineFragment;

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
    ViewPager mTabPager;
    @InjectView(R.id.homeLayout)
    LinearLayout mHomeLayout;
    @InjectView(R.id.followLayout)
    LinearLayout mFollowLayout;
    @InjectView(R.id.findLayout)
    LinearLayout mFindLayout;
    @InjectView(R.id.mineLayout)
    LinearLayout mMineLayout;
    private LinkedList<Fragment> mFragments = new LinkedList<>();
    private LinkedList<TextView> mTabTexts = new LinkedList<>();
    private LinkedList<ImageView> mTabIcons = new LinkedList<>();
    private int[] mTabTextColorArray = new int[]{0xFF999999, 0xFFFF0000};
    private int[] mTabIcomArray = new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher//未选中
            , R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};//选中
    private int mTabCount = 4;
    private MainTabPagerAdapter mTabAdapter;

    @Override
    protected int onLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onPrepare() {
        mTabTexts.add(mHomeText);
        mTabTexts.add(mFollowText);
        mTabTexts.add(mFindText);
        mTabTexts.add(mMineText);
        mTabIcons.add(mHomeIcon);
        mTabIcons.add(mFollowIcon);
        mTabIcons.add(mFindIcon);
        mTabIcons.add(mMineIcon);
        mFragments.add(new HomeFragment());
        mFragments.add(new FollowFragment());
        mFragments.add(new FindFragment());
        mFragments.add(new MineFragment());
        mTabAdapter = new MainTabPagerAdapter(getSupportFragmentManager(), mFragments);
        mTabPager.setAdapter(mTabAdapter);
        setCurrentItem(0);
    }

    @Override
    protected void onEvent() {
        mHomeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCurrentItem(0);
            }
        });
        mFollowLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCurrentItem(1);
            }
        });
        mFindLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCurrentItem(2);
            }
        });
        mMineLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCurrentItem(3);
            }
        });
    }

    private void setCurrentItem(int item) {
        mTabPager.setCurrentItem(item);
        for (int i = 0; i < mTabCount; i++) {
            if (i == item) {
                mTabTexts.get(i).setTextColor(mTabTextColorArray[1]);
                mTabIcons.get(i).setImageResource(mTabIcomArray[i + mTabCount]);
            } else {
                mTabTexts.get(i).setTextColor(mTabTextColorArray[0]);
                mTabIcons.get(i).setImageResource(mTabIcomArray[i]);
            }
        }
    }
}
