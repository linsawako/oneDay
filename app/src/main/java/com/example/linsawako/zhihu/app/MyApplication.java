package com.example.linsawako.zhihu.app;

import org.litepal.LitePal;

/**
 * Created by linsawako on 2017/2/7.
 */

public class MyApplication extends android.support.multidex.MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
    }
}
