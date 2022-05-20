package com.smartservice.adapter.http.spring.dto.saida.mesa;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MesaProdutoResponse {

    @JsonProperty("nome_produto")
    private String nomeProduto;

    public MesaProdutoResponse(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public MesaProdutoResponse() {
    }

    public String getNomeProduto() {
        return nomeProduto;
    }
}
