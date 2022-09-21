package com.vyshakh.geocode.Model;

public class GeocoderResult {
    private GeocoderGeometry geometry;

    public GeocoderGeometry getGeometry(){
        return geometry;
    }

    public void setGeometry(GeocoderGeometry geometry){
        this.geometry = geometry;
    }
}
