package com.mllweb.presenter.DAL;

import com.mllweb.presenter.IDAL.IMainPresenter;
import com.mllweb.presenter.IVIEW.MainView;

/**
 * Created by Android on 2016/7/14.
 */
public class MainPresenter implements IMainPresenter {
    MainView mView;

    public MainPresenter(MainView view) {
        mView = view;
    }

    @Override
    public void setTabPosition(int position, int tabSize) {
        for (int i = 0; i < tabSize; i++) {
            if (position == i) {
                mView.setSelect(i);
            } else {
                mView.setUnSelect(i);
            }
        }
    }
}
