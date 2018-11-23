package com.example.alexander.thevergetopnews;

import android.app.Application;

import com.example.alexander.thevergetopnews.Components.ComponentProvider;
import com.example.alexander.thevergetopnews.Components.Injection;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Injection.setComponentProvider(new ComponentProvider(this));
    }
}


