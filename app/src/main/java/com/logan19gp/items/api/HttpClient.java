package com.logan19gp.items.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class HttpClient {
    private static HttpClient INSTANCE = null;
    private final Retrofit retrofit;
    OkHttpClient httpClient;
    private static final String API_BASE_URL = "http://ads.appia.com/";


    private HttpClient() {
        final OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();

        httpClient = httpBuilder
                .addInterceptor(new StandardHeaderInterceptor())
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
    }

    public static synchronized void initialize() {
        if (INSTANCE == null) {
            INSTANCE = new HttpClient();
        }
    }

    public static synchronized HttpClient getInstance() {
        return INSTANCE;
    }

    public static ApiService getApiService() throws IllegalStateException {
        if (HttpClient.getInstance() == null) {
            throw new IllegalStateException("HttpClient is not initialized!");
        }
        return HttpClient.getInstance().getRetrofitInstance().create(ApiService.class);
    }

    public Retrofit getRetrofitInstance() {
        return retrofit;
    }

    public OkHttpClient getOkHttpClient() {
        return httpClient;
    }

    private class StandardHeaderInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request().newBuilder().build();
            return chain.proceed(request);
        }
    }
}
