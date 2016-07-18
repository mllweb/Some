package com.mllweb.model.model;

import com.mllweb.model.CallBack;
import com.mllweb.model.bean.TabBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 2016/7/18.
 */
public class TabModel {
    public void getTab(CallBack<List<TabBean>> callBack) {
        List<TabBean> tabs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TabBean tab = new TabBean();
            tab.setTabId(i);
            tab.setTabName("标签"+i);
            tabs.add(tab);
        }
        callBack.onSuccess(tabs);
    }
}
