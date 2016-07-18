package com.mllweb.some.fragment;

import android.net.Uri;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mllweb.some.BaseFragment;
import com.mllweb.some.R;

import butterknife.InjectView;

/**
 * Created by Android on 2016/7/18.
 */
public class HomeTabBannerFragment extends BaseFragment {
    @InjectView(R.id.draweeView)
    SimpleDraweeView mDraweeView;

    @Override
    protected int onLayout() {
        return R.layout.fragment_home_tab_banner;
    }

    @Override
    protected void onPrepare() {
        Uri uri = Uri.parse("http://img6.pplive.cn/2012/09/04/18101520736.jpg");
        mDraweeView.setImageURI(uri);
    }

    @Override
    protected void onPresenter() {

    }
}
