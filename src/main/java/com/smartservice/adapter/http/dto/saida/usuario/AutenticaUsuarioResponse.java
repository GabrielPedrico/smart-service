package com.smartservice.adapter.http.dto.saida.usuario;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id_usuario","usuario","nivel_usuario","message"})
public class AutenticaUsuarioResponse {

    @JsonProperty("id_usuario")
    private String idUsuario;
    private String usuario;
    @JsonProperty("nivel_usuario")
    private String nivelUsuario;
    private String message;

    public AutenticaUsuarioResponse(String message, String usuario, String nivelUsuario,String idUsuario) {
        this.message = message;
        this.usuario = usuario;
        this.nivelUsuario = nivelUsuario;
        this.idUsuario = idUsuario;
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

    public String getIdUsuario() {
        return idUsuario;
    }
}
