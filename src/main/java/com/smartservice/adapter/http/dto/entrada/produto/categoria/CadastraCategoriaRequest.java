package com.smartservice.adapter.http.dto.entrada.produto.categoria;

import javax.validation.constraints.NotBlank;

public class CadastraCategoriaRequest {

    @NotBlank
    private String nome;

    public CadastraCategoriaRequest(String nome) {
        this.nome = nome;
    }

    @Deprecated
    public CadastraCategoriaRequest() {
    }

    public String getNome() {
        return nome;
    }
}
