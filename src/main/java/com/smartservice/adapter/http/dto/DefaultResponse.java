package com.smartservice.adapter.http.dto;

public class DefaultResponse {

    private String message;

    public DefaultResponse(String produtoId) {
        this.message = produtoId;
    }

    @Deprecated
    public DefaultResponse() {
    }

    public String getMessage() {
        return message;
    }
}
