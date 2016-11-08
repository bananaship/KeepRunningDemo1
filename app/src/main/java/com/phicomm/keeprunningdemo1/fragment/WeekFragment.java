package com.phicomm.keeprunningdemo1.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.phicomm.keeprunningdemo1.R;
import com.phicomm.keeprunningdemo1.view.BarCardThree;

/**
 * @创建者 xu_hao
 * @创建时间 2016/11/6 21:53
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */
public class WeekFragment extends Fragment {

    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_week, null);

        (new BarCardThree((CardView) mView.findViewById(R.id.card6), getContext())).init();

        return mView;
    }
}
