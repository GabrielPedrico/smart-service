package com.smartservice.core.exceptions;

import org.springframework.http.HttpStatus;

public class EmailNaoCadastradoException extends HttpException{

    public EmailNaoCadastradoException(String message) {
        super(message.replace("\n","").trim());
    }

    @Override
    public HttpStatus getHttpStatus() {return HttpStatus.BAD_REQUEST;}
}
