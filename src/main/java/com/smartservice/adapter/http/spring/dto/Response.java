package com.smartservice.adapter.http.spring.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

    @JsonProperty("data")
    private T data;

    public Response(T data) {
        this.data = data;
    }
    @Deprecated
    public Response() {}

    public T getData() {
        return data;
    }
}
