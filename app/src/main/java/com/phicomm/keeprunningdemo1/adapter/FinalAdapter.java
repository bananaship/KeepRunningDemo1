package com.phicomm.keeprunningdemo1.adapter;

import android.support.v4.view.ViewCompat;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 万能listview adapter
 * 1.通过构造函数,传入集合数据,条目布局id,viewholder接口监听对象
 * 2.在创建万能适配器对象的类中,通过接口回调获取到的holder对象,去调用getViewByID方法获取布局上的控件
 * 3.给控件设置数据
 */
public class FinalAdapter<T> extends BaseAdapter {
    private List<T> mDatas = new ArrayList<>();//适配器数据集合
    private int mLayoutID;//item条目布局id

    public FinalAdapter(List<T> datas, int layoutID, OnViewHolderListener onViewHolderListener) {
        mDatas = datas;
        mLayoutID = layoutID;
        mOnViewHolderListener = onViewHolderListener;
    }


    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(),mLayoutID, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        convertView.setScaleX(0.7f);
        convertView.setScaleY(0.7f);
        convertView.setAlpha(0.2f);
        ViewCompat.animate(convertView).scaleX(1.0f).scaleY(1.0f).alpha(1.0f)
                .setInterpolator(new OvershootInterpolator()).setDuration(600).start();

        //将holder绑定数据的操作回调出去,让接口实现类去实现
        mOnViewHolderListener.setViewHolder(holder,position);

        return convertView;
    }

    public static class ViewHolder{
        View mView;
        private SparseArray<View> mViewMap = new SparseArray<>();//key为int类型的map集合

        public ViewHolder(View view){
            mView=view;//item条目复用的view
        }

        //让viewholder对象在外部获取view布局上控件的方法
        public View getViewByid(int viewID){
            View subView = mViewMap.get(viewID);//通过map提高了findview的效率
            if (subView == null) {
                subView = mView.findViewById(viewID);
                mViewMap.put(viewID,subView);
            }
            return subView;
        }

    }

    private OnViewHolderListener mOnViewHolderListener;//接口成员变量
    public interface OnViewHolderListener{
        void setViewHolder(ViewHolder holder, int position);
    }
}
