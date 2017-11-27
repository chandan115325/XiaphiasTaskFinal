package com.chandan.android.xiaphiastask;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chandan.android.xiaphiastask.OfflineData.OfflineDataProvider;
import com.chandan.android.xiaphiastask.model.DataItem;
import com.chandan.android.xiaphiastask.model.Items;
import com.chandan.android.xiaphiastask.model.Snippet;
import com.chandan.android.xiaphiastask.rcb.NewsAdapter;
import com.chandan.android.xiaphiastask.rcb.RCBPresenter;
import com.chandan.android.xiaphiastask.utils.NetworkHelper;

public class DetailActivity extends AppCompatActivity {

    private ImageView detailThumbnail;
    private TextView description;
    private TextView channelTitle;
    private TextView publishedAt;
    private String videoId;
    DataItem dataItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setTitle("");

        detailThumbnail = (ImageView) findViewById(R.id.detail_image);
        channelTitle = (TextView) findViewById(R.id.channel_title);
        publishedAt = (TextView) findViewById(R.id.detail_publishedAt);

        description = (TextView) findViewById(R.id.detail_description);

        Items item = getIntent().getExtras().getParcelable(NewsAdapter.ITEM_KEY);

        dataItem = getIntent().getExtras().getParcelable(NewsAdapter.DATA_ITEM_KEY);

        if (item == null) {
            detailDataItem();
            //throw new AssertionError("Null data item received!");
        } else {

            Snippet snippet = new Snippet();
            String detailsETAG = item.getEtag();

            for (int i = 0; i < RCBPresenter.itemList.size(); i++) {
                if (NetworkHelper.hasNetworkAccess(getApplicationContext())) {


                    if (detailsETAG.equals(RCBPresenter.itemList.get(i).getEtag())) {

                        String poster = RCBPresenter.itemList.get(i).getSnippet().getThumbnails().getHigh().getUrl();


                        Glide.with(this)
                                .load(poster)
                                .placeholder(R.drawable.load)
                                .into(detailThumbnail);

                        channelTitle.setText(RCBPresenter.itemList.get(i).getSnippet().getChannelTitle());
                        publishedAt.setText(RCBPresenter.itemList.get(i).getSnippet().getPublishedAt());
                        description.setText(RCBPresenter.itemList.get(i).getSnippet().getDescription());

                    }
                }


                //  String title = item.getSnippet().getTitle();
                Log.w("Details", detailsETAG);
            }
        }
    }

    public void detailDataItem() {

        int poster = dataItem.getImageId();

        for (int i = 0; i < OfflineDataProvider.dataItemList.size(); i++) {
            if (dataItem.getEtag().equals(OfflineDataProvider.dataItemList.get(i).getEtag()))
                Glide.with(this)
                        .load(poster)
                        .placeholder(OfflineDataProvider.dataItemList.get(i).getImageId())
                        .into(detailThumbnail);
            videoId = dataItem.getVideoId();
        }

        channelTitle.setText(dataItem.getChannelTitle());
        publishedAt.setText(dataItem.getPublishedAt());
        description.setText(dataItem.getDescription());


    }

    public void goToVideo(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+videoId));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("VIDEO_ID", videoId);
        startActivity(intent);



    }
}
