package com.vyshakh.geocode.Model;

public class GeocoderBase {
    private GeocoderResult results[];

    public GeocoderResult[] getResults(){
        return results;
    }

    public void setResults(GeocoderResult[] results){
        this.results = results;
    }
}
