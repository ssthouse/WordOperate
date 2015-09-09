package com.ssthouse.model;

/**
 * Marker的bean类
 * Created by ssthouse on 2015/9/9.
 */
public class MarkerItem {

    private String prjName;

    private String longtitude;

    private String latitude;

    public MarkerItem(String prjName, String longtitude, String latitude) {
        this.prjName = prjName;
        this.longtitude = longtitude;
        this.latitude = latitude;
    }

    //getter----------and----------setter-----------

    public String getPrjName() {
        return prjName;
    }

    public void setPrjName(String prjName) {
        this.prjName = prjName;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
