package com.chandan.android.xiaphiastask;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chandan.android.xiaphiastask.model.DataItem;
import com.chandan.android.xiaphiastask.model.Items;

import java.util.List;

/**
 * Created by delaroy on 5/18/17.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    public static final String ITEM_KEY = "item_key";
    public static final String DATA_ITEM_KEY = "data_item_key";
    private Context mContext;
    private List<Items> itemList;
    private List<DataItem> dataList;

    public NewsAdapter(Context mContext, List<DataItem> dataList) {
        this.mContext = mContext;

        this.dataList = dataList;
    }

    public NewsAdapter(Context mContext, List<Items> itemList, List<DataItem> dataList) {
        this.mContext = mContext;
        this.itemList = itemList;
        this.dataList = dataList;
    }


    @Override
    public NewsAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_card, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final NewsAdapter.MyViewHolder viewHolder, int i) {


        if (itemList != null) {
            String description = itemList.get(i).getSnippet().getTitle();
            viewHolder.description.setText(description);


            String channelTitle = itemList.get(i).getSnippet().getChannelTitle();
            viewHolder.title.setText(channelTitle);


            String publishedAt = itemList.get(i).getSnippet().getPublishedAt();
            viewHolder.publishedAt.setText(publishedAt);


            String poster = itemList.get(i).getSnippet().getThumbnails().getHigh().getUrl();


            Glide.with(mContext)
                    .load(poster)
                    .placeholder(R.drawable.load)
                    .into(viewHolder.thumbnail);
        } else {
            String description = dataList.get(i).getTitle();
            viewHolder.description.setText(description);


            String channelTitle = dataList.get(i).getChannelTitle();
            viewHolder.title.setText(channelTitle);


            String publishedAt = dataList.get(i).getPublishedAt();
            viewHolder.publishedAt.setText(publishedAt);

        /*String imageFile = dataList.get(i).getPosterPath();
        InputStream inputStream = null;
        try {
            inputStream = mContext.getAssets().open(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Drawable d = Drawable.createFromStream(inputStream, null);*/
            int poster = dataList.get(i).getImageId();
            // viewHolder.thumbnail.setImageResource(poster);


            Glide.with(mContext)
                    .load(poster)
                    .placeholder(poster)
                    .into(viewHolder.thumbnail);
        }

    }


    @Override
    public int getItemCount() {


        return dataList.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description, publishedAt;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            description = (TextView) view.findViewById(R.id.description);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            publishedAt = (TextView) view.findViewById(R.id.publishedAt);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        Intent intent = new Intent(mContext, DetailActivity.class);
                        if (itemList != null) {
                            Items clickedItem = itemList.get(pos);
                            intent.putExtra(ITEM_KEY, clickedItem);
                        }

                        DataItem clickedDataItem = dataList.get(pos);


                        intent.putExtra(DATA_ITEM_KEY, clickedDataItem);


                        // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                        //Toast.makeText(v.getContext(), "You clicked " + clickedItem.getSnippet().getTitle(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
