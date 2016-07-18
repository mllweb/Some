package com.mllweb.some.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Android on 2016/7/14.
 */
public class ScrollViewPager extends ViewPager {


    private boolean isScroll;

    public ScrollViewPager(Context context) {
        super(context);
    }

    public ScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean isScroll() {
        return isScroll;
    }

    public void setScroll(boolean scroll) {
        isScroll = scroll;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (isScroll == false) {
            return false;
        } else {
            return super.onTouchEvent(ev);
        }

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (isScroll == false) {
            return false;
        } else {
            return super.onInterceptTouchEvent(ev);
        }

    }
}
