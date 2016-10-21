package com.logan19gp.items.api;

import android.net.Uri;

import com.squareup.picasso.Downloader;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttp3Downloader implements Downloader {
    @Override
    public Response load(Uri uri, int networkPolicy) throws IOException {
        final OkHttpClient okHttpClient = HttpClient.getInstance().getOkHttpClient();

        okhttp3.Response response = okHttpClient.newCall(
                new Request.Builder()
                        .url(uri.toString())
                        .build()
        ).execute();

        return new Response(response.body().byteStream(), false, response.body().contentLength());
    }

    @Override
    public void shutdown() {
        //Do nothing
    }
}
