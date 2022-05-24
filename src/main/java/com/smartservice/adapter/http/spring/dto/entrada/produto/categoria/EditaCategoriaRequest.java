package com.smartservice.adapter.http.spring.dto.entrada.produto.categoria;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class EditaCategoriaRequest {

    @NotBlank
    @JsonProperty("nome_novo")
    private String nomeNovo;

    public EditaCategoriaRequest(String nome) {
        this.nomeNovo = nome;
    }

    @Deprecated
    public EditaCategoriaRequest() {
    }

    @Override
    public String toString() {
        return "EditaCategoriaRequest{" +
                "nomeNovo='" + nomeNovo + '\'' +
                '}';
    }

    public String getNomeNovo() {
        return nomeNovo;
    }
}
