package com.smartservice.core.exceptions;

import org.springframework.http.HttpStatus;

public class PedidoNaoExistenteException extends HttpException{

    public PedidoNaoExistenteException(String message) {
        super(message.replace("\n","").trim());
    }

    @Override
    public HttpStatus getHttpStatus() {return HttpStatus.NOT_FOUND;}
}
