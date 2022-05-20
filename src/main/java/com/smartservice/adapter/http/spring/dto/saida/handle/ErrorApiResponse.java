package com.smartservice.adapter.http.spring.dto.saida.handle;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ErrorApiResponse {

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("status")
    private String status;

    @JsonProperty("message")
    private String message;

    @JsonProperty("message_log")
    private String messageLog;

    @JsonProperty("validations")
    private String validations;

    @JsonProperty("status_code")
    private String statusCode;

    @JsonProperty("path")
    private String path;

    public ErrorApiResponse(String timestamp, String status, String message, String messageLog, String validations, String statusCode, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.messageLog = messageLog;
        this.validations = validations;
        this.statusCode = statusCode;
        this.path = path;
    }
    @Deprecated
    public ErrorApiResponse(){}

    public String getTimestamp() {
        return timestamp;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageLog() {
        return messageLog;
    }

    public String getValidations() {
        return validations;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getPath() {
        return path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorApiResponse that = (ErrorApiResponse) o;
        return Objects.equals(timestamp, that.timestamp) && Objects.equals(status, that.status) && Objects.equals(message, that.message) && Objects.equals(messageLog, that.messageLog) && Objects.equals(validations, that.validations) && Objects.equals(statusCode, that.statusCode) && Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, status, message, messageLog, validations, statusCode, path);
    }
}
