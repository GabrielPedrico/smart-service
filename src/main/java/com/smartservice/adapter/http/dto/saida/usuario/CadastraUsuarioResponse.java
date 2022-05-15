package com.smartservice.adapter.http.dto.saida.usuario;

public class CadastraUsuarioResponse {

    private String message;

    public CadastraUsuarioResponse(String message) {
        this.message = message;
    }
    @Deprecated
    public CadastraUsuarioResponse() {
    }

    public String getMessage() {
        return message;
    }
}
