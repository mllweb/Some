package com.mllweb.model;

/**
 * Created by Android on 2016/7/18.
 */
public interface CallBack<T> {
    void onSuccess(T t);

    void failure(String error);
}
