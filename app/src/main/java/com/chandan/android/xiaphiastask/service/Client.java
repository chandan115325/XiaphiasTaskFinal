package com.chandan.android.xiaphiastask.service;

import android.content.Context;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by delaroy on 11/27/17.
 */
public class Client {

    public static Context mcontext;

    public static String BASE_URL = "https://www.googleapis.com/";
    public static Retrofit retrofit = null;


    // Retrofit caching with OkHttpClient.

    public static Retrofit getClient() {
        if (retrofit == null) {
            int cacheSize = 10 * 1024 * 1024; // 10 MB
            Cache cache = new Cache(mcontext.getCacheDir(), cacheSize);

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .cache(cache)
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
