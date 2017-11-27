package com.chandan.android.xiaphiastask.service;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chandan on 11/26/17.
 */
public class Client {

    public static Context mContext  ;

    public static String BASE_URL = "https://www.googleapis.com/youtube/v3/";
    public static Retrofit retrofit = null;


    // Retrofit caching with OkHttpClient.

    public static Retrofit getClient() {
        if (retrofit == null) {
            int cacheSize = 10 * 1024 * 1024; // 10 MB
           // Cache cache = new Cache(mContext.getCacheDir(), cacheSize);

            //OkHttpClient okHttpClient = new OkHttpClient.Builder()
            //        .cache(cache)
            //        .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    //.client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
