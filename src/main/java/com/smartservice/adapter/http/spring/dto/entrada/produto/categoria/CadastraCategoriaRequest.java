package com.smartservice.adapter.http.spring.dto.entrada.produto.categoria;

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

    @Override
    public String toString() {
        return "CadastraCategoriaRequest{" +
                "nome='" + nome + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }
}
