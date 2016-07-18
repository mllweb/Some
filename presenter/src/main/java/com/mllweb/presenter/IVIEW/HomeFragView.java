package com.mllweb.presenter.IVIEW;

import com.mllweb.model.bean.TabBean;

import java.util.List;

/**
 * Created by Android on 2016/7/18.
 */
public interface HomeFragView {
    void configTabLayout(List<TabBean> tabs);
    void setSelect( int position);

    void setUnSelect( int position);
}
