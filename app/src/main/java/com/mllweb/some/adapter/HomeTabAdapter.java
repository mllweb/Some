package com.mllweb.some.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mllweb.model.bean.TabBean;
import com.mllweb.some.R;
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

    public HomeTabAdapter(Context context) {
        this.mContext = context;
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

        public HeadHolder(View itemView) {
            super(itemView);
            pager = (ScrollViewPager) itemView.findViewById(R.id.bannerPager);
            AutoUtils.auto(itemView);
            AutoUtils.autoTextSize(itemView);
        }
    }

    public class Holder extends RecyclerView.ViewHolder {

        public Holder(View itemView) {
            super(itemView);
            AutoUtils.auto(itemView);
            AutoUtils.autoTextSize(itemView);
        }
    }
}
