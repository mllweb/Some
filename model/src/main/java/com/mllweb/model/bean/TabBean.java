package com.mllweb.model.bean;

import java.io.Serializable;

/**
 * Created by Android on 2016/7/18.
 */
public class TabBean implements Serializable {
    private int tabId;
    private String tabName;

    public int getTabId() {
        return tabId;
    }

    public void setTabId(int tabId) {
        this.tabId = tabId;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }
}
