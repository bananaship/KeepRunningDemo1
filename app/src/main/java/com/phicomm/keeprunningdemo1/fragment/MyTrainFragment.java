package com.phicomm.keeprunningdemo1.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.loonggg.weekcalendar.view.WeekCalendar;
import com.phicomm.keeprunningdemo1.R;
import com.phicomm.keeprunningdemo1.global.App;
import com.phicomm.keeprunningdemo1.view.HorizontialListView;
import com.phicomm.keeprunningdemo1.view.MonthView;
import com.phicomm.keeprunningdemo1.view.WeekView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * @创建者 xu_hao
 * @创建时间 2016/11/9 9:22
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */
public class MyTrainFragment extends BaseFragment {

    private View mView;

    private MonthView    monthView;
    private WeekView     weekView;
    private LinearLayout contentLayout;
    private Calendar     now;

    private WeekCalendar weekCalendar;


    private HorizontialListView mHl_sport_study;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_my_train, null);

        initView();

        //        initCalendar();

        return mView;
    }

    private void initView() {
        mHl_sport_study = (HorizontialListView) mView.findViewById(R.id.hl_sport_study);
        mHl_sport_study.setAdapter(mAdapter);

        weekCalendar = (WeekCalendar) mView.findViewById(R.id.week_calendar);
        List<String> list = new ArrayList<>();
        list.add("2016-09-13");
        list.add("2016-10-13");
        list.add("2016-10-11");
        list.add("2016-10-10");
        list.add("2016-10-16");
        weekCalendar.setSelectDates(list);
        //设置日历点击事件
        weekCalendar.setOnDateClickListener(new WeekCalendar.OnDateClickListener() {
            @Override
            public void onDateClick(String time) {
                Toast.makeText(App.context, time, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*private void initView() {
        mWeekCalendar = (WeekCalendar) mView.findViewById(R.id.WeekCalendar);

        mWeekCalendar.setOnDateClickListener(new OnDateClickListener() {
            @Override
            public void onDateClick(DateTime dateTime) {
                Toast.makeText(App.context, "你选中的日期是 " + dateTime.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }*/


    /* private void initCalendar() {
         now = Calendar.getInstance();

         monthView = (MonthView) mView.findViewById(R.id.month_calendar);
         weekView = (WeekView) mView.findViewById(R.id.week_calendar);
         contentLayout = (LinearLayout) mView.findViewById(R.id.content_layout);


         monthView.setDPMode(DPMode.SINGLE);
         monthView.setDate(now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1);
         monthView.setFestivalDisplay(true);
         monthView.setTodayDisplay(true);
         monthView.setOnDateChangeListener(this);
         monthView.setOnDatePickedListener(this);

         weekView.setDPMode(DPMode.SINGLE);
         weekView.setDate(now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1);
         weekView.setFestivalDisplay(true);
         weekView.setTodayDisplay(true);
         weekView.setOnDatePickedListener(this);

     }*/
    private static String[] dataObjects = new String[]{"Text #1",
            "Text #2",
            "Text #3"};

    private int[] mImageId = new int[]{R.mipmap.run1, R.mipmap.run2, R.mipmap.run3};
    String[] titles = new String[]{"热身运动", "拉伸运动", "准备活动"};

    private BaseAdapter mAdapter = new BaseAdapter() {

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View retval = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sport_study, null);

            TextView title = (TextView) retval.findViewById(R.id.tv_text);
            ImageView iv_sprot = (ImageView) retval.findViewById(R.id.iv_sprot);

            iv_sprot.setImageResource(mImageId[position]);
            title.setText(titles[position]);

            return retval;
        }
    };
}
