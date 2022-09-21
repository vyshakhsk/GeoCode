package com.vyshakh.geocode.Dao;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.vyshakh.geocode.Model.PositionStack;
import com.vyshakh.geocode.Model.Result;

@Component
public class PositionStackRetreiver implements ILocationRetriever {
    @Override
    public Result getLatitudeLogitude(String location){
        UriComponents uri = UriComponentsBuilder.newInstance()
                    .scheme("http").host("api.positionstack.com")
                    .path("/v1/forward")
                    .queryParam("access_key", "ef84e49f3fc753c7c04b4a1f76a683f6")
                    .queryParam("query", location)
                    .build();

        ResponseEntity<PositionStack> response = new RestTemplate().getForEntity(uri.toUriString(), PositionStack.class);
        var res = new Result();
        try{
            res = response.getBody().getResult()[0];
        } catch(Exception e){
            System.err.println("Json Format Exception for Google API");
        }
        return res;
    }
}
