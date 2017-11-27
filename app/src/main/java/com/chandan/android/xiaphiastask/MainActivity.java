package com.chandan.android.xiaphiastask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.chandan.android.xiaphiastask.OfflineData.OfflineDataProvider;
import com.chandan.android.xiaphiastask.model.DataItem;
import com.chandan.android.xiaphiastask.model.ItemResponse;
import com.chandan.android.xiaphiastask.model.Items;
import com.chandan.android.xiaphiastask.service.Client;
import com.chandan.android.xiaphiastask.service.Service;
import com.chandan.android.xiaphiastask.utils.NetworkHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NewsAdapter adapter;
    public static final String LOG_TAG = NewsAdapter.class.getName();
    private List<DataItem> dataList = OfflineDataProvider.dataItemList;
    public static List<Items> itemList;
    ProgressDialog pd;
    private SwipeRefreshLayout swipeContainer;
    //private FavoriteDbHelper favoriteDbHelper;
    private AppCompatActivity activity = MainActivity.this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        setTitle("");
        //initViews();
        itemList = new ArrayList<>();

        if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            //recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
            //for LinearLayout like a list use this code
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            //recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
            //for LinearLayout like a list use this code
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }


            initViews();

    }

    public Activity getActivity(){
        Context context = this;
        while (context instanceof ContextWrapper){
            if (context instanceof Activity){
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;

    }

    private void initViews(){

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.main_content);
        swipeContainer.setColorSchemeResources(android.R.color.holo_orange_dark);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh(){
                initViews();
                Toast.makeText(MainActivity.this, "Data Refreshed", Toast.LENGTH_SHORT).show();
            }
        });
        if(NetworkHelper.hasNetworkAccess(this)) {
            loadJSON();
        }


        recyclerView.setAdapter(new NewsAdapter(getApplicationContext(),  dataList));
        recyclerView.smoothScrollToPosition(0);
        if (swipeContainer.isRefreshing()){
            swipeContainer.setRefreshing(false);
        }
    }



    private void loadJSON(){

        try{


            Client Client = new Client();
            Service apiService =
                    Client.getClient().create(Service.class);
            Call<ItemResponse> call = apiService.dataItems();
            call.enqueue(new Callback<ItemResponse>() {
                @Override
                public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
                    itemList = response.body().getItems();



                    recyclerView.setAdapter(new NewsAdapter(getApplicationContext(), itemList, dataList));
                    recyclerView.smoothScrollToPosition(0);
                    if (swipeContainer.isRefreshing()){
                        swipeContainer.setRefreshing(false);
                    }

                }

                @Override
                public void onFailure(Call<ItemResponse> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                    Toast.makeText(MainActivity.this, "Error Fetching Data!", Toast.LENGTH_SHORT).show();


                }
            });
        }catch (Exception e){
            Log.d("Error", e.getMessage());
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
