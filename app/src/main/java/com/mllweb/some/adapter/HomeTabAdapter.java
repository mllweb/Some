package com.mllweb.some.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mllweb.model.bean.TabBean;
import com.mllweb.some.R;
import com.mllweb.some.fragment.HomeTabBannerFragment;
import com.mllweb.some.widget.ScrollViewPager;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 2016/7/18.
 */
public class HomeTabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<TabBean> mData = new ArrayList<>();
    private Context mContext;
    FragmentManager mFragmentManager;

    public HomeTabAdapter(Context context, FragmentManager fragmentManager) {
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
        for (int i = 0; i < 20; i++) {
            TabBean tabBean = new TabBean();
            tabBean.setTabId(i + 1);
            mData.add(tabBean);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        if (viewType == 1) {
            holder = new HeadHolder(LayoutInflater.from(mContext).inflate(R.layout.adapter_home_tab_head, parent, false));
        } else {
            holder = new Holder(LayoutInflater.from(mContext).inflate(R.layout.adapter_home_tab, parent, false));
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeadHolder) {
            HeadHolder headHolder = (HeadHolder) holder;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getTabId();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class HeadHolder extends RecyclerView.ViewHolder {
        ScrollViewPager pager;
        HomeTabBannerPagerAdapter bannerAdapter;
        List<Fragment> fragments = new ArrayList<>();

        public HeadHolder(View itemView) {
            super(itemView);
            pager = (ScrollViewPager) itemView.findViewById(R.id.bannerPager);
            AutoUtils.auto(itemView);
            AutoUtils.autoTextSize(itemView);
            fragments.add(new HomeTabBannerFragment());
            fragments.add(new HomeTabBannerFragment());
            fragments.add(new HomeTabBannerFragment());
            fragments.add(new HomeTabBannerFragment());
            fragments.add(new HomeTabBannerFragment());
            fragments.add(new HomeTabBannerFragment());
            bannerAdapter = new HomeTabBannerPagerAdapter(mFragmentManager, fragments);
            setBanner(pager, bannerAdapter, fragments);
        }
    }

    public class Holder extends RecyclerView.ViewHolder {
        RecyclerView recycler;
        HomeTabItemAdapter adapter;

        public Holder(View itemView) {
            super(itemView);
            recycler = (RecyclerView) itemView.findViewById(R.id.recycler);
            adapter = new HomeTabItemAdapter(mContext);
            recycler.setLayoutManager(new GridLayoutManager(mContext, 2));
            recycler.setAdapter(adapter);
            calcHeight(recycler, adapter);
            AutoUtils.auto(itemView);
            AutoUtils.autoTextSize(itemView);
        }
    }

    private void setBanner(ScrollViewPager pager, final HomeTabBannerPagerAdapter bannerAdapter, List<Fragment> fragments) {

        pager.setAdapter(bannerAdapter);
        pager.setOffscreenPageLimit(fragments.size());
        pager.setScroll(true);
        pager.setCurrentItem(1);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (positionOffset == 0) {
                    int count = bannerAdapter.getCount();
                    if (position == 0) {
                        pager.setCurrentItem(count - 2, false);
                    }
                    if (position == (count - 1)) {
                        pager.setCurrentItem(1, false);
                    }
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

    private void calcHeight(RecyclerView recycler, HomeTabItemAdapter adapter) {
        if (recycler == null) return;
        if (adapter == null) {
            return;
        }
        int spanCount = ((GridLayoutManager) recycler.getLayoutManager()).getSpanCount();
        int totalHeight = 0;
        for (int i = 0; i < adapter.getItemCount() / spanCount; i++) {
            View listItem = adapter.onCreateViewHolder(recycler, 0).getView();
            listItem.measure(0, 0);//计算每项   Item的高度
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = recycler.getLayoutParams();
        params.height = totalHeight;
        //循环完之后,要计算出getDividerHeight(空白处占得height)   才是Listview的高度
        recycler.setLayoutParams(params);
    }
}
