package com.mllweb.some.application;

import com.zhy.autolayout.config.AutoLayoutConifg;

/**
 * Created by Android on 2016/7/13.
 */
public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize();
    }
}
