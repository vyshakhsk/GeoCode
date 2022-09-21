package com.vyshakh.geocode.Model;

public class Result {
    private String latitude;
    private String longitude;

    public String getLatitude(){
        return this.latitude;
    }

    public String getLongitude(){
        return this.longitude;
    }

    public void setLatitude(String lat){
        latitude = lat;
    }

    public void setLongitude(String lon){
        longitude = lon;
    }
}
