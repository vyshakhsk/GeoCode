package com.vyshakh.geocode.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PositionStack {
    @JsonProperty("data")
    Result result[];

    public Result[] getResult(){
        return result;
    }

    public void setResult(Result[] results){
        this.result = results;
    }
}
