package com.chandan.android.xiaphiastask.service;

import com.chandan.android.xiaphiastask.model.ItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by delaroy on 5/18/17.
 */
public interface Service {




    String FEED = "youtube/v3/search?part=id,snippet&maxResults=20&channelId=UCCq1xDJMBRF61kiOgU90_kw&key=AIzaSyBRLPDbLkFnmUv13B-Hq9rmf0y7q8HOaVs";



    @GET(FEED)
    Call<ItemResponse> dataItems();

}
