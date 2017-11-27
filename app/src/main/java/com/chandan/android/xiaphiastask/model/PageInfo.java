package com.chandan.android.xiaphiastask.model;

/**
 * Created by CHANDAN on 11/24/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PageInfo implements Parcelable {

    @SerializedName("totalResults")
    @Expose
    private int totalResults;
    @SerializedName("resultsPerPage")
    @Expose
    private int resultsPerPage;

    protected PageInfo(Parcel in) {
        totalResults = in.readInt();
        resultsPerPage = in.readInt();
    }

    public static final Creator<PageInfo> CREATOR = new Creator<PageInfo>() {
        @Override
        public PageInfo createFromParcel(Parcel in) {
            return new PageInfo(in);
        }

        @Override
        public PageInfo[] newArray(int size) {
            return new PageInfo[size];
        }
    };

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getResultsPerPage() {
        return resultsPerPage;
    }

    public void setResultsPerPage(int resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(totalResults);
        parcel.writeInt(resultsPerPage);
    }
}
