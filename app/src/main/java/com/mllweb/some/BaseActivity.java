package com.mllweb.some;

import android.os.Bundle;

import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;

/**
 * Created by Android on 2016/7/13.
 */
public abstract class BaseActivity extends AutoLayoutActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(onLayout());
        ButterKnife.inject(this);
        onPrepare();
        onEvent();
    }

    protected abstract int onLayout();

    protected void onEvent() {
    }

    protected void onPrepare() {
    }
}
