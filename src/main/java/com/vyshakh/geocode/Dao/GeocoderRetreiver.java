package com.vyshakh.geocode.Dao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.vyshakh.geocode.Exception.ApiError;
import com.vyshakh.geocode.Model.GeocoderBase;
import com.vyshakh.geocode.Model.Result;

@Component
public class GeocoderRetreiver implements ILocationRetriever {
    @Override
    public Result getLatitudeLogitude(String location) throws RuntimeException {
        UriComponents uri = UriComponentsBuilder.newInstance()
                    .scheme("https").host("maps.googleapis.com/")
                    .path("/maps/api/geocode/json")
                    .queryParam("address", location)
                    .queryParam("key", "AIzaSyB8CzA_YkneEfBEUs8thIV7Mx1q6UztcrE")
                    .build();

        ResponseEntity<GeocoderBase> response = new RestTemplate().getForEntity(uri.toUriString(), GeocoderBase.class);
        if(response.getStatusCode() != HttpStatus.OK){
            System.err.println("Google API Error");
            throw new ApiError("Google Api");
        }

        var res = new Result();
        try{
            var loc = response.getBody().getResults()[0].getGeometry().getLocation();
            res.setLatitude(loc.getLat());
            res.setLongitude(loc.getLng());
        } catch (Exception e){
            System.err.println("Json Format Exception for Google API");
        }
        return res;
    }
}
