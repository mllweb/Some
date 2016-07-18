package com.mllweb.some.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.DraweeView;
import com.mllweb.model.bean.TabBean;
import com.mllweb.some.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 2016/7/18.
 */
public class HomeTabItemAdapter extends RecyclerView.Adapter<HomeTabItemAdapter.Holder> {
    private List<TabBean> mData = new ArrayList<>();
    private Context mContext;

    public HomeTabItemAdapter(Context context) {
        this.mContext = context;
        for (int i = 0; i < 4; i++) {
            TabBean tabBean = new TabBean();
            tabBean.setTabId(i + 1);
            mData.add(tabBean);
        }
    }

    @Override
    public HomeTabItemAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        Holder holder = new Holder(LayoutInflater.from(mContext).inflate(R.layout.adapter_home_tab_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(HomeTabItemAdapter.Holder holder, int position) {
        Uri uri = Uri.parse("http://img6.pplive.cn/2012/09/04/18101520736.jpg");
        holder.draweeView.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
DraweeView draweeView;
        public Holder(View itemView) {
            super(itemView);
            draweeView= (DraweeView) itemView.findViewById(R.id.draweeView);
            AutoUtils.auto(itemView);
            AutoUtils.autoTextSize(itemView);
        }

        public View getView() {
            return itemView;
        }
    }
}
