package com.phicomm.keeprunningdemo1.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.phicomm.keeprunningdemo1.R;
import com.phicomm.keeprunningdemo1.adapter.SportDetailsAdapter;
import com.phicomm.keeprunningdemo1.bean.SportDetails;
import com.phicomm.keeprunningdemo1.utils.ListViewUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建者 xu_hao
 * @创建时间 2016/11/6 22:00
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */
public class AllFragment extends Fragment {

    private View     mView;
    private ListView mLv_train_info2;

    private List<SportDetails> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_all, null);

        initView();
        initData();

        return mView;
    }

    private void initView() {
        mLv_train_info2 = (ListView) mView.findViewById(R.id.lv_train_info2);
    }

    private void initData() {
        SportDetails sportDetails1 = new SportDetails("3.35", "00:41:44", "06'44\"", "467");
        SportDetails sportDetails2 = new SportDetails("3.35", "00:42:45", "06'45\"", "468");
        SportDetails sportDetails3 = new SportDetails("3.35", "00:43:46", "06'46\"", "469");

        list.clear();

        list.add(sportDetails1);
        list.add(sportDetails2);
        list.add(sportDetails3);

        mLv_train_info2.setAdapter(new SportDetailsAdapter(list));

        //动态的改变listview的高度
        ListViewUtils.setListViewHeightBasedOnChildren(mLv_train_info2);
    }
}
