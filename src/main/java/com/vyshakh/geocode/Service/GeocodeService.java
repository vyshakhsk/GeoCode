package com.vyshakh.geocode.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.vyshakh.geocode.Dao.ILocationRetriever;
import com.vyshakh.geocode.Model.Result;

@Service
public class GeocodeService {
    @Autowired
    @Qualifier("geocoderRetreiver")
    private ILocationRetriever _locationRetriever;

    @Cacheable(cacheNames = {"locations"}, key = "#location")
    public Result getLocation(String location) throws RuntimeException{
        System.out.println("Calling External API");
        try{
            return _locationRetriever.getLatitudeLogitude(location);
        } catch(Exception e){
            throw e;
        }
    }
}
