package com.vyshakh.geocode.Controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vyshakh.geocode.Exception.ApiError;
import com.vyshakh.geocode.Service.GeocodeService;

@RestController
public class GeocodeController{
    @Autowired
    private GeocodeService _geocodeService;

    @GetMapping(value = "/getCodes", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> code(@RequestParam("file") MultipartFile file){
        String line;
        StringBuilder result = new StringBuilder();
        try{
            InputStream is = file.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                var ps = _geocodeService.getLocation(line);
                result.append(ps.getLatitude()).append(",").append(ps.getLongitude()).append('\n');
            }
        } 
        catch(ApiError e){
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.TEXT_PLAIN).body("Something Went Wrong");
        }

        return ResponseEntity.ok().body(result.toString());
    }
}