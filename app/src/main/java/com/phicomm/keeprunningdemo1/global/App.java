package com.phicomm.keeprunningdemo1.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * @创建者 xu_hao
 * @创建时间 2016/11/6 21:40
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */
public class App extends Application {
    public static Context context = null;
    public static Handler handler = null;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        handler = new Handler();
    }
}
