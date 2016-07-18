package com.mllweb.some;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Android on 2016/7/18.
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(onLayout(), container, false);
        ButterKnife.inject(this, view);
        onPresenter();
        onPrepare();
        onEvent();
        return view;
    }


    protected abstract int onLayout();

    protected void onEvent() {
    }

    protected void onPrepare() {
    }

    protected abstract void onPresenter();
}
