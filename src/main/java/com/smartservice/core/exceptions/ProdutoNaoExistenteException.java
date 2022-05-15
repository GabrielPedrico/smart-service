package com.smartservice.core.exceptions;

import org.springframework.http.HttpStatus;

public class ProdutoNaoExistenteException extends HttpException{

    public ProdutoNaoExistenteException(String message) {
        super(message.replace("\n","").trim());
    }

    @Override
    public HttpStatus getHttpStatus() {return HttpStatus.NOT_FOUND;}
}
