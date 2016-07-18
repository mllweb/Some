package com.mllweb.presenter.DAL;

import com.mllweb.model.CallBack;
import com.mllweb.model.bean.TabBean;
import com.mllweb.model.model.TabModel;
import com.mllweb.presenter.IDAL.IHomeFragPresenter;
import com.mllweb.presenter.IVIEW.HomeFragView;

import java.util.List;

/**
 * Created by Android on 2016/7/18.
 */
public class HomeFragPresenter implements IHomeFragPresenter {
    HomeFragView mHomeFragView;
    TabModel mTabModel;

    public HomeFragPresenter(HomeFragView homeFragView) {
        mHomeFragView = homeFragView;
        mTabModel = new TabModel();
    }

    @Override
    public void onTabLayout() {
        mTabModel.getTab(new CallBack<List<TabBean>>() {
            @Override
            public void onSuccess(List<TabBean> tabBeen) {
                mHomeFragView.configTabLayout(tabBeen);
            }

            @Override
            public void failure(String error) {

            }
        });
    }

    @Override
    public void setTabPosition(int position, int tabSize) {
        for (int i=0;i<tabSize;i++){
            if (position == i) {
                mHomeFragView.setSelect(i);
            } else {
                mHomeFragView.setUnSelect(i);
            }
        }
    }
}
