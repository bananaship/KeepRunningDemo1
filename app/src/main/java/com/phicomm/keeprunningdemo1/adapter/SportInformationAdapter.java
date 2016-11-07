package com.phicomm.keeprunningdemo1.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.phicomm.keeprunningdemo1.bean.FragmentInfo;

import java.util.List;

/**
 * @创建者 xu_hao
 * @创建时间 2016/11/6 22:03
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */
public class SportInformationAdapter extends FragmentStatePagerAdapter {
    private List<FragmentInfo> mshowList;

    public SportInformationAdapter(FragmentManager fm, List<FragmentInfo> showItems) {
        super(fm);
        this.mshowList = showItems;
    }

    @Override
    public Fragment getItem(int position) {
        return mshowList.get(position).fragment;
    }

    @Override
    public int getCount() {
        return mshowList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mshowList.get(position).title;
    }
}
