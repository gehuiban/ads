package com.logan19gp.items;

import android.app.Application;
import com.logan19gp.items.api.HttpClient;
import com.logan19gp.items.api.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

public class MyApplication extends Application {

    public static Picasso picasso;

    @Override
    public void onCreate() {
        super.onCreate();

        HttpClient.initialize();
        picasso = new Picasso.Builder(this).downloader(new OkHttp3Downloader()).build();
    }
}