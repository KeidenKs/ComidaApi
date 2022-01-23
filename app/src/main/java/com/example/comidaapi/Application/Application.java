package com.example.comidaapi.Application;

import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;

public class Application extends android.app.Application {

    private static Application instance;
    private static Context appContext;

    public static Application getInstance() {
        return instance;
    }

    public static Context getAppContext() {
        return appContext;
    }

    public void setAppContext(Context mAppContext) {
        this.appContext = mAppContext;
    }

    @Override
    public void onCreate() {

        super.onCreate();
        instance = this;

        this.setAppContext(getApplicationContext());
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

}
