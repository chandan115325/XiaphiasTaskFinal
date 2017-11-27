package com.chandan.android.xiaphiastask.service;

import com.chandan.android.xiaphiastask.model.ItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by chandan on 11/26/17.
 */
public interface Service {




    String FEED = "search?part=id,snippet&maxResults=20&channelId=UCCq1xDJMBRF61kiOgU90_kw&key=AIzaSyBRLPDbLkFnmUv13B-Hq9rmf0y7q8HOaVs";


    @GET("search")
   // @GET(FEED)
    Call<ItemResponse> dataItems(@Query("part") String part,
                                 @Query("maxResults") String maxResults,
                                 @Query("channelId") String channelId,
                                 @Query("key") String key);


}
