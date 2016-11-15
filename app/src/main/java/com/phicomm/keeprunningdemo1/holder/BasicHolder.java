package com.phicomm.keeprunningdemo1.holder;


import android.view.View;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.phicomm.keeprunningdemo1.R;

import butterknife.ButterKnife;


public abstract class BasicHolder<T> {
    //定义一个view
    View view;
    public DisplayImageOptions mOptions;

    public View getView() {
        return view;
    }

    public BasicHolder() {
        view = createView();


        ButterKnife.bind(this, view);

        //将view和ViewHolder绑定在一起
        view.setTag(this);

        //会识别图片的方向信息
        //显示的效果
        mOptions = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)//会识别图片的方向信息
                .displayer(new FadeInBitmapDisplayer(500))
                .build();
        //      .displayer(new RoundedBitmapDisplayer(36)).build();
    }

    /**
     * 生成布局
     *
     * @return
     */
    protected abstract View createView();

    /**
     * 绑定数据
     *
     * @param appInfo
     */
    public abstract void bindView(T appInfo);
}
