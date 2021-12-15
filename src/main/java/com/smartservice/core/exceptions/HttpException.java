package com.smartservice.core.exceptions;

import org.springframework.http.HttpStatus;

public abstract class HttpException extends RuntimeException{

    protected HttpException(String message){super(message);}

    public abstract HttpStatus getHttpStatus();
}
