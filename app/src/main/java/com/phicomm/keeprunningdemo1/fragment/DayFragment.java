package com.phicomm.keeprunningdemo1.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.phicomm.keeprunningdemo1.R;
import com.phicomm.keeprunningdemo1.global.App;
import com.phicomm.keeprunningdemo1.view.BarCardThree;
import com.phicomm.keeprunningdemo1.view.LineCardTwo;

/**
 * @创建者 xu_hao
 * @创建时间 2016/11/6 21:51
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */
public class DayFragment extends Fragment {

    private ViewPager mViewpager;
    private int[] imageResIds = {R.mipmap.map1, R.mipmap.map2, R.mipmap.map3};// 图片资源数组

    private LinearLayout mLl_point_group;// 用来显示点的容器

    private int prevousPosition = 0;// 用来记录上一个点的位置

    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 0:
                    // 将广告条显示到下一个页面
                    int currentItem = mViewpager.getCurrentItem();
                    mViewpager.setCurrentItem(currentItem + 1);
                    // 再发送一个延迟消息
                    mHandler.sendEmptyMessageDelayed(0, 2000);
                    break;

                default:
                    break;
            }
        }

        ;
    };
    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_day, null);


        initView();
        initData();
        int startoffset = Integer.MAX_VALUE / 2 % imageResIds.length;
        mViewpager.setCurrentItem(Integer.MAX_VALUE / 2 - startoffset);// 设置viewpager从哪一个位置开始展示
        // mViewpager.setCurrentItem(imageResIds.length*10000000);

        // 延迟2秒发送一个消息
        //        mHandler.sendEmptyMessageDelayed(0, 2000);

        return mView;
    }

    private void initData() {
        mViewpager.setAdapter(new MyAdapter());
        // 动态添加小圆点
        for (int i = 0; i < imageResIds.length; i++) {
            // 创建 小圆点
            ImageView point = new ImageView(App.context);
            // 6设置图片宽高为6个像素
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(6,
                    6);
            params.leftMargin = 5;// 相当于marginleft 5个像素的间距
            point.setBackgroundResource(R.drawable.point_bg_selector);
            // point.setImageResource(R.drawable.point_pressed);
            if (i != 0) {
                // point.setImageResource(R.drawable.point_normal);
                point.setLayoutParams(params);
                point.setEnabled(false);// 除了第一个点，其他点设置为不可用，就是一个小白点
            }
            // point.setBackgroundResource(R.drawable.point_normal);
            mLl_point_group.addView(point);

        }
    }

    private void initView() {

        (new BarCardThree((CardView) mView.findViewById(R.id.card6), getContext())).init();
        (new LineCardTwo((CardView) mView.findViewById(R.id.card9))).init();


        mViewpager = (ViewPager) mView.findViewById(R.id.vp_map);

        mLl_point_group = (LinearLayout) mView.findViewById(R.id.ll_point_group);

        // 给viewpager设置页面改变监听
        mViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            // 当页面被选中时才调用该方法
            @Override
            public void onPageSelected(int position) {
                int pos = position % imageResIds.length;
                // 先把前一个点设置为未选中
                mLl_point_group.getChildAt(prevousPosition).setEnabled(false);
                prevousPosition = pos;

                System.out.println("onPageSelected" + position);
                System.out.println("onPageSelected" + pos);
                // 让对应的小圆点设置值选中
                mLl_point_group.getChildAt(pos).setEnabled(true);
            }

            // 当页面滑动时，实时调用该方法

            /**
             * position:位置索引值 positionOffset：页面滑动的百分比
             * positionOffsetPixels:页面滑动过去的像素值
             */
            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
                // TODO Auto-generated method stub

            }

            // 当滑动状态改变时，调用这个方法
            @Override
            public void onPageScrollStateChanged(int state) {
                // TODO Auto-generated method stub

            }
        });

        //        // 给viewpager设置一个触摸监听
        //        mViewpager.setOnTouchListener(new View.OnTouchListener() {
        //
        //            @Override
        //            public boolean onTouch(View v, MotionEvent event) {
        //                switch (event.getAction()) {
        //                    case MotionEvent.ACTION_DOWN:
        //                        // 停止自动轮播
        //                        mHandler.removeCallbacksAndMessages(null);
        //                        break;
        //                    case MotionEvent.ACTION_UP:
        //                        // 重启自动轮播
        //                        mHandler.sendEmptyMessageDelayed(0, 2000);
        //                        break;
        //
        //                    default:
        //                        break;
        //                }
        //                return false;//由我们自己处理触摸
        //            }
        //        });
    }

    private class MyAdapter extends PagerAdapter {

        // 与baseadapter里面getcount一致，决定了viewpager的长度
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return Integer.MAX_VALUE;
        }

        // 如果将要展示的界面view与初始化方法返回的object对象一致的话才显示
        @Override
        public boolean isViewFromObject(View view, Object object) {
            // TODO Auto-generated method stub
            return view == object;
        }

        // 类型与getview方法，来对条目界面进行初始化

        /**
         * container 容器 就是viewpager自身 position 将要初始化的位置索引
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            int pos = position % imageResIds.length;
            // 0 0 1 1 2 2 3 3 4 4 5 0 [0,4]
            System.out.println("instantiateItem  :" + position);
            // 创建出对应界面
            ImageView iv = new ImageView(App.context);
            // iv.setImageResource(imageResIds[position]);//设置了src属性，图片有多大就显示多大
            iv.setBackgroundResource(imageResIds[pos]);
            // 要显示的界面添加到容器
            container.addView(iv);
            // 将要显示的界面进行返回
            return iv;
        }

        // 销毁方法

        /**
         * container: 容器 就是viewpager自身 position: 将要销毁的位置索引 object ： 将要被销毁的对象
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // 从容器中删除要被销毁的对象
            System.out.println("destroyItem  :" + position);
            container.removeView((View) object);
        }
    }
}
