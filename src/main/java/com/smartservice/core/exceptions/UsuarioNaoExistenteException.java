package com.smartservice.core.exceptions;

import org.springframework.http.HttpStatus;

public class UsuarioNaoExistenteException extends HttpException{

    public UsuarioNaoExistenteException(String message) {
        super(message.replace("\n","").trim());
    }

    @Override
    public HttpStatus getHttpStatus() {return HttpStatus.NOT_FOUND;}
}
