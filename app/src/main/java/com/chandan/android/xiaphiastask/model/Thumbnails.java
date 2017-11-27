package com.chandan.android.xiaphiastask.model;

/**
 * Created by CHANDAN on 11/24/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thumbnails {

    @SerializedName("default")
    @Expose
    private Default _default;
    @SerializedName("medium")
    @Expose
    private Medium medium;
    @SerializedName("high")
    @Expose
    private High high;

    public Thumbnails(Default _default, Medium medium, High high){

        this. _default = _default;
        this.medium = medium;
        this.high = high;

    }

    public Thumbnails(){}

    public Default getDefault() {
        return _default;
    }

    public void setDefault(Default _default) {
        this._default = _default;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public High getHigh() {
        return high;
    }

    public void setHigh(High high) {
        this.high = high;
    }

}