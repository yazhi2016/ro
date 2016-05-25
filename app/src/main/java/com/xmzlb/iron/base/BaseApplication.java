package com.xmzlb.iron.base;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class BaseApplication extends Application {
    //	private List<Activity> activities = new ArrayList<Activity>();
    @Override
    public void onCreate() {
        super.onCreate();
        //Fresco初始化
        Fresco.initialize(this);

    }

}
