package com.example.work.base1;

import android.app.Application;

public class BaseApplication extends Application {

    private static BaseApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static BaseApplication getApplication() {
        return application;
    }
}
