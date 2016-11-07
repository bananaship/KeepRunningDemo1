package com.phicomm.keeprunningdemo1.bean;

import android.support.v4.app.Fragment;

public class FragmentInfo {
    public String title;

    public Fragment fragment;

    public FragmentInfo(String title, Fragment fragment) {
        this.title = title;
        this.fragment = fragment;
    }
}
