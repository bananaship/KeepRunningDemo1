package com.phicomm.keeprunningdemo1.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

/**
 * @创建者 xu_hao
 * @创建时间 2016/11/3 10:58
 * @描述 fragment的基类
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */
public class BaseFragment extends Fragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化接口

    }

    /**
     * 统一的显示错误提示的方法
     * 逻辑根据需要自己写
     * @param error
     */
    public void showError(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

}
