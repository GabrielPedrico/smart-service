package com.smartservice.adapter.http.dto.saida.produto;

public class CadastraProdutoResponse {

    private String message;

    public CadastraProdutoResponse(String message) {
        this.message = message;
    }
    @Deprecated
    public CadastraProdutoResponse() {
    }

    public String getMessage() {
        return message;
    }
}
