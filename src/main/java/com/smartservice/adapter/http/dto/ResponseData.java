package com.smartservice.adapter.http.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseData<T>{

    @JsonProperty("data")
    private List<T> data;

    public ResponseData(List<T> data) {
        this.data = data;
    }
    @Deprecated
    public ResponseData() {}

    public List<T> getData() {
        return data;
    }
}
