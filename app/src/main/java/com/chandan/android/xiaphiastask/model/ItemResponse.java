package com.chandan.android.xiaphiastask.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by CHANDAN on 11/24/2017.
 */

public class ItemResponse implements Parcelable {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("nextPageToken")
    @Expose
    private String nextPageToken;
    @SerializedName("regionCode")
    @Expose
    private String regionCode;
    @SerializedName("pageInfo")
    @Expose
    private PageInfo pageInfo;
    @SerializedName("items")
    @Expose
    private List<Items> items = null;

    protected ItemResponse(Parcel in) {
        kind = in.readString();
        etag = in.readString();
        nextPageToken = in.readString();
        regionCode = in.readString();
    }

    public static final Creator<ItemResponse> CREATOR = new Creator<ItemResponse>() {
        @Override
        public ItemResponse createFromParcel(Parcel in) {
            return new ItemResponse(in);
        }

        @Override
        public ItemResponse[] newArray(int size) {
            return new ItemResponse[size];
        }
    };

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(kind);
        parcel.writeString(etag);
        parcel.writeString(nextPageToken);
        parcel.writeString(regionCode);
    }
}