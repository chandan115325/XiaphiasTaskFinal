package com.chandan.android.xiaphiastask.rcb;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chandan.android.xiaphiastask.R;
import com.chandan.android.xiaphiastask.database.DataSource;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private  com.chandan.android.xiaphiastask.rcb.RCBPresenter RCBPresenter ;
    private RecyclerView recyclerView;
    private NewsAdapter adapter;
    ProgressDialog pd;
    private SwipeRefreshLayout swipeContainer;
    //private FavoriteDbHelper favoriteDbHelper;
    private AppCompatActivity activity = MainActivity.this;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        RCBPresenter = new RCBPresenter(this);

        setTitle("");
        //initViews();
        com.chandan.android.xiaphiastask.rcb.RCBPresenter.itemList = new ArrayList<>();

        if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            //recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
            //for LinearLayout like a list use this code
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            //recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
            //for LinearLayout like a list use this code
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }

        DataSource dataSource = new DataSource(activity);
        dataSource.seedDatabase(RCBPresenter.dataList);

        RCBPresenter.initViews();

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


    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setSwipeContainer(SwipeRefreshLayout swipeContainer) {
        this.swipeContainer = swipeContainer;
    }

    public SwipeRefreshLayout getSwipeContainer() {
        return swipeContainer;
    }
}
