package com.chandan.android.xiaphiastask.rcb;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.util.Log;
import android.widget.Toast;

import com.chandan.android.xiaphiastask.OfflineData.OfflineDataProvider;
import com.chandan.android.xiaphiastask.R;
import com.chandan.android.xiaphiastask.model.DataItem;
import com.chandan.android.xiaphiastask.model.ItemResponse;
import com.chandan.android.xiaphiastask.model.Items;
import com.chandan.android.xiaphiastask.service.Client;
import com.chandan.android.xiaphiastask.service.Service;
import com.chandan.android.xiaphiastask.utils.NetworkHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RCBPresenter {
    private final MainActivity mainActivity;
    public static final String LOG_TAG = NewsAdapter.class.getName();
    public List<DataItem> dataList;
    public static List<Items> itemList;

    public RCBPresenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.dataList = OfflineDataProvider.dataItemList;
    }

    public void initViews() {

        mainActivity.getRecyclerView().setItemAnimator(new DefaultItemAnimator());

        mainActivity.setSwipeContainer((SwipeRefreshLayout) mainActivity.findViewById(R.id.main_content));
        mainActivity.getSwipeContainer().setColorSchemeResources(android.R.color.holo_orange_dark);
        mainActivity.getSwipeContainer().setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initViews();
                Toast.makeText(mainActivity, "Data Refreshed", Toast.LENGTH_SHORT).show();
            }
        });
        if (NetworkHelper.hasNetworkAccess(mainActivity)) {
            loadJSON();
        }


        mainActivity.getRecyclerView().setAdapter(new NewsAdapter(mainActivity.getApplicationContext(), dataList));
        mainActivity.getRecyclerView().smoothScrollToPosition(0);
        if (mainActivity.getSwipeContainer().isRefreshing()) {
            mainActivity.getSwipeContainer().setRefreshing(false);
        }
    }

    public void loadJSON() {

        try {


            Client Client = new Client();
            Service apiService =
                    Client.getClient().create(Service.class);
            Call<ItemResponse> call = apiService.dataItems("id,snippet","20",APIConstant.CHANNEL_ID,
                    APIConstant.KEY);
            call.enqueue(new Callback<ItemResponse>() {
                @Override
                public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
                    itemList = response.body().getItems();

                   // part=id,snippet&maxResults=20&channelId=UCCq1xDJMBRF61kiOgU90_kw&key=AIzaSyBRLPDbLkFnmUv13B-Hq9rmf0y7q8HOaVs

                    mainActivity.getRecyclerView().setAdapter(new NewsAdapter(mainActivity.getApplicationContext(), itemList, dataList));
                    mainActivity.getRecyclerView().smoothScrollToPosition(0);
                    if (mainActivity.getSwipeContainer().isRefreshing()) {
                        mainActivity.getSwipeContainer().setRefreshing(false);
                    }

                }

                @Override
                public void onFailure(Call<ItemResponse> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                    Toast.makeText(mainActivity, "Error Fetching Data!", Toast.LENGTH_SHORT).show();


                }
            });
        } catch (Exception e) {
            Log.d("Error", e.getMessage());
            Toast.makeText(mainActivity, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}