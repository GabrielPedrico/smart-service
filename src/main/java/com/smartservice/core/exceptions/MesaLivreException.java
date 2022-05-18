package com.smartservice.core.exceptions;

import org.springframework.http.HttpStatus;

public class MesaLivreException extends HttpException{

    public MesaLivreException(String message) {
        super(message.replace("\n","").trim());
    }

    @Override
    public HttpStatus getHttpStatus() {return HttpStatus.UNPROCESSABLE_ENTITY;}
}
