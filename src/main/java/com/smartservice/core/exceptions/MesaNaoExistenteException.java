package com.smartservice.core.exceptions;

import org.springframework.http.HttpStatus;

public class MesaNaoExistenteException extends HttpException{

    public MesaNaoExistenteException(String message) {
        super(message.replace("\n","").trim());
    }

    @Override
    public HttpStatus getHttpStatus() {return HttpStatus.UNPROCESSABLE_ENTITY;}
}
