package com.vyshakh.geocode.Dao;

import com.vyshakh.geocode.Model.Result;

public interface ILocationRetriever {
    Result getLatitudeLogitude(String location);
}
