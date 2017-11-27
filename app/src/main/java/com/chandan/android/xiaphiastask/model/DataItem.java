package com.chandan.android.xiaphiastask.model;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;

import com.chandan.android.xiaphiastask.database.ItemsTable;

/**
 * Created by CHANDAN on 11/26/2017.
 */

public class DataItem implements Parcelable {

    public DataItem(String title, String description, String posterPath, String publishedAt, String videoId, String etag, String channelTitle, int imageId) {
        this.title = title;
        this.description = description;
        this.posterPath = posterPath;
        this.publishedAt = publishedAt;
        this.videoId = videoId;
        this.etag = etag;
        this.channelTitle = channelTitle;
        this.imageId = imageId;
    }

    private String title;

    private String description;

    private String posterPath;

    private String publishedAt;

    private String videoId;

    private String etag;

    int imageId;

    public DataItem() {

    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    private String channelTitle;

    protected DataItem(Parcel in) {
        title = in.readString();
        description = in.readString();
        posterPath = in.readString();
        publishedAt = in.readString();
        videoId = in.readString();
        etag = in.readString();
        channelTitle = in.readString();
    }

    public static final Creator<DataItem> CREATOR = new Creator<DataItem>() {
        @Override
        public DataItem createFromParcel(Parcel in) {
            return new DataItem(in);
        }

        @Override
        public DataItem[] newArray(int size) {
            return new DataItem[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeString(posterPath);
        parcel.writeString(publishedAt);
        parcel.writeString(videoId);
        parcel.writeString(etag);
        parcel.writeString(channelTitle);
    }

    public ContentValues toValues() {

        ContentValues values = new ContentValues(7);

        values.put(ItemsTable.COLUMN_ID, videoId);
        values.put(ItemsTable.COLUMN_TITLE, title);
        values.put(ItemsTable.COLUMN_DESCRIPTION, description);
        values.put(ItemsTable.COLUMN_POSTER_PATH, posterPath);
        values.put(ItemsTable.COLUMN_PUBLISHED_AT, publishedAt);
        values.put(ItemsTable.COLUMN_ETAG, etag);
        values.put(ItemsTable.COLUMN_IMAGE_ID, imageId);
        values.put(ItemsTable.COLUMN_CHANNEL_TITLE, channelTitle);

        return values;

    }

    @Override
    public String toString() {
        return "DataItem{" +
                "videoId='" + videoId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", publishedAt=" + publishedAt +
                ", etag=" + etag +
                ", imageId='" + imageId + '\'' +
                ", channelTitle='" +channelTitle +
                '}';
    }


}
