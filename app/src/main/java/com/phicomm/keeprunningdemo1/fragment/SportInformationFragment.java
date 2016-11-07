package com.phicomm.keeprunningdemo1.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.phicomm.keeprunningdemo1.R;
import com.phicomm.keeprunningdemo1.adapter.SportInformationAdapter;
import com.phicomm.keeprunningdemo1.bean.FragmentInfo;
import com.phicomm.keeprunningdemo1.global.App;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @创建者 xu_hao
 * @创建时间 2016/11/6 21:38
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */
public class SportInformationFragment extends Fragment {
    @Bind(R.id.pst_si_title)
    com.phicomm.keeprunningdemo1.view.PagerSlidingTab mPstSiTitle;
    @Bind(R.id.vp_si_shows)
    ViewPager                                         mVpSiShows;
    @Bind(R.id.ll_si_layout)
    LinearLayout                                      mLlSiLayout;
    @Bind(R.id.dl_combine_menu)
    DrawerLayout                                      mDlCombineMenu;
    private List<FragmentInfo> mShowItems = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(App.context, R.layout.fragment_sport_information, null);
        ButterKnife.bind(this, view);

        //初始化
        initData();

        return view;
    }

    private void initData() {
        mShowItems.clear();
        mShowItems.add(new FragmentInfo("日", new DayFragment()));
        mShowItems.add(new FragmentInfo("周", new WeekFragment()));
        mShowItems.add(new FragmentInfo("月", new MonthFragment()));
        mShowItems.add(new FragmentInfo("总", new AllFragment()));

        mVpSiShows.setAdapter(new SportInformationAdapter(getFragmentManager(), mShowItems));

        mPstSiTitle.setShouldExpand(true);
        mPstSiTitle.setViewPager(mVpSiShows);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
