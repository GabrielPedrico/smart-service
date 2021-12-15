package com.smartservice.core.exceptions;

import org.springframework.http.HttpStatus;

public class UsuarioNaoAutorizadoException extends HttpException{

    public UsuarioNaoAutorizadoException(String message) {
        super(message.replace("\n","").trim());
    }

    @Override
    public HttpStatus getHttpStatus() {return HttpStatus.UNAUTHORIZED;}
}
