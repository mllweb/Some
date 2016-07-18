package com.mllweb.some.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import com.mllweb.model.bean.TabBean;
import com.mllweb.some.BaseFragment;
import com.mllweb.some.R;
import com.mllweb.some.adapter.HomeTabAdapter;

import butterknife.InjectView;

/**
 * Created by Android on 2016/7/18.
 */
public class HomeTabFragment extends BaseFragment {
    private TabBean mTab;
    @InjectView(R.id.recycler)
    RecyclerView mRecycler;
    @InjectView(R.id.searchLayout)
    RelativeLayout mSearchLayout;
    HomeTabAdapter mTabAdapter;

    @Override
    protected int onLayout() {
        return R.layout.fragment_home_tab;
    }

    @Override
    protected void onPrepare() {
        Bundle bundle = getArguments();
        mTab = (TabBean) bundle.getSerializable("tab");
        mTabAdapter = new HomeTabAdapter(getContext());
        mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecycler.setAdapter(mTabAdapter);
    }

    @Override
    protected void onEvent() {
        mRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int mMargin;

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mSearchLayout.getLayoutParams();
                if (mMargin == 0) {
                    mMargin = params.height;
                }
                if (dy > 0) {
                    params.topMargin = params.topMargin -Math.abs(dy);
                    if (params.topMargin < -mMargin) {
                        params.topMargin = -mMargin;
                    }
                    mSearchLayout.setLayoutParams(params);
                } else {
                    params.topMargin = params.topMargin + Math.abs(dy);
                    if (params.topMargin > 0) {
                        params.topMargin = 0;
                    }
                    mSearchLayout.setLayoutParams(params);
                }
            }
        });
    }

    @Override
    protected void onPresenter() {

    }
}
