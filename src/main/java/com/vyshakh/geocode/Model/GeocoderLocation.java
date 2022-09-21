package com.vyshakh.geocode.Model;

public class GeocoderLocation {
    private String lat;
    private String lng;

    public String getLat(){
        return this.lat;
    }

    public String getLng(){
        return this.lng;
    }

    public void setLat(String lat){
        this.lat = lat;
    }

    public void setLng(String lng){
        this.lng = lng;
    }
}
