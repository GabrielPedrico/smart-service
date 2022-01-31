package com.smartservice.adapter.http.dto.saida.usuario;

public class AutenticaUsuarioResponse {

    private String message;
    private String usuario;
    private String nivelUsuario;

    public AutenticaUsuarioResponse(String message, String usuario, String nivelUsuario) {
        this.message = message;
        this.usuario = usuario;
        this.nivelUsuario = nivelUsuario;
    }

    @Deprecated
    public AutenticaUsuarioResponse() {
    }

    public String getMessage() {
        return message;
    }

    public String getNivelUsuario() {
        return nivelUsuario;
    }

    public String getUsuario() {
        return usuario;
    }
}
