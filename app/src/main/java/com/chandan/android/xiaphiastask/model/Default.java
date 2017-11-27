package com.chandan.android.xiaphiastask.model;

/**
 * Created by CHANDAN on 11/24/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Default implements Parcelable {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("width")
    @Expose
    private int width;
    @SerializedName("height")
    @Expose
    private int height;

    public Default(String url, int width, int height){

        this.url = url;
        this.width = width;
        this.height = height;

    }

    public Default(){}

    protected Default(Parcel in) {
        url = in.readString();
        width = in.readInt();
        height = in.readInt();
    }

    public static final Creator<Default> CREATOR = new Creator<Default>() {
        @Override
        public Default createFromParcel(Parcel in) {
            return new Default(in);
        }

        @Override
        public Default[] newArray(int size) {
            return new Default[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(url);
        parcel.writeInt(width);
        parcel.writeInt(height);
    }
}
