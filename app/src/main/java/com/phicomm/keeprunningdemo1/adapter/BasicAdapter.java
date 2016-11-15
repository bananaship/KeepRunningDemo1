package com.phicomm.keeprunningdemo1.adapter;

import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.BaseAdapter;

import com.phicomm.keeprunningdemo1.holder.BasicHolder;

import java.util.ArrayList;
import java.util.List;

public abstract class BasicAdapter<T> extends BaseAdapter {
    private List<T> mShowItems = new ArrayList<>();

    public BasicAdapter(List<T> showItems) {
        this.mShowItems = showItems;
    }

    @Override
    public int getCount() {
        return mShowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mShowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    protected int headType = 0;
    protected int bodyType = 1;

    //类型
    @Override
    public int getItemViewType(int position) {
        if (mShowItems.get(position) instanceof String) {
            return headType;
        } else {
            return bodyType;
        }

    }

    //种类
    @Override
    public int getViewTypeCount() {
        return 2;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BasicHolder holder;
        if (convertView == null) {
            //            convertView = View.inflate(GooglePlayApp.context, R.layout.item_home, null);
            //            holder = new ViewHolder(convertView);
            holder = createViewHolder(position);
            //            convertView.setTag(holder);
        } else {
            holder = (BasicHolder) convertView.getTag();
        }

        //赋值
        //        holder.bindView(holder, mShowItems.get(position));
        holder.bindView(mShowItems.get(position));


        View view = holder.getView();
        //先缩小
        view.setScaleX(.6f);
        view.setScaleY(.6f);

        //还原动画(夹带弹的效果)
        ViewCompat.animate(view).scaleX(1f).scaleY(1f).setDuration(600).setInterpolator(new OvershootInterpolator()).start();

        return view;
    }

    public abstract BasicHolder createViewHolder(int postion);

    /*private void bindView(ViewHolder holder, HomeBean.AppInfo appInfo) {
        holder.tv_home_item_title.setText(appInfo.getName());
        //获取文件大小
        String size = Formatter.formatFileSize(GooglePlayApp.context, appInfo.getSize());
        holder.tv_home_item_size.setText(size);
        holder.tv_home_item_desc.setText(appInfo.getDes());

        holder.rb_home_item_score.setRating(appInfo.getStars());

        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)//会识别图片的方向信息
                .displayer(new FadeInBitmapDisplayer(500)).build();//显示的效果
        //					.displayer(new RoundedBitmapDisplayer(36)).build();


        ImageLoader.getInstance().displayImage("http://127.0.0.1:8090/image?name=" + appInfo.getIconUrl(), holder.iv_home_item_icon, options);
    }*/

    /*class ViewHolder {
        ImageView iv_home_item_icon;
        RatingBar rb_home_item_score;
        TextView  tv_home_item_title;
        TextView  tv_home_item_size;
        TextView  tv_home_item_desc;

        //定义一个view
        View view;

        public View getView() {
            return view;
        }

        public ViewHolder() {
            view = View.inflate(GooglePlayApp.context, R.layout.item_home, null);
            //将view和ViewHolder绑定在一起
            view.setTag(this);

            iv_home_item_icon = (ImageView) view.findViewById(R.id.iv_home_item_icon);
            rb_home_item_score = (RatingBar) view.findViewById(R.id.rb_home_item_score);
            tv_home_item_title = (TextView) view.findViewById(R.id.tv_home_item_title);
            tv_home_item_size = (TextView) view.findViewById(R.id.tv_home_item_size);
            tv_home_item_desc = (TextView) view.findViewById(R.id.tv_home_item_desc);
        }

        public void bindView(HomeBean.AppInfo appInfo) {
            tv_home_item_title.setText(appInfo.getName());
            //获取文件大小
            String size = Formatter.formatFileSize(GooglePlayApp.context, appInfo.getSize());
            tv_home_item_size.setText(size);
            tv_home_item_desc.setText(appInfo.getDes());

            rb_home_item_score.setRating(appInfo.getStars());

            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    .showImageOnLoading(R.mipmap.ic_launcher)
                    .showImageForEmptyUri(R.mipmap.ic_launcher)
                    .showImageOnFail(R.mipmap.ic_launcher)
                    .cacheInMemory(true)
                    .cacheOnDisk(true)
                    .considerExifParams(true)//会识别图片的方向信息
                    .displayer(new FadeInBitmapDisplayer(500)).build();//显示的效果
            //					.displayer(new RoundedBitmapDisplayer(36)).build();


            ImageLoader.getInstance().displayImage("http://127.0.0.1:8090/image?name=" + appInfo.getIconUrl(), iv_home_item_icon, options);
        }
    }*/
}
