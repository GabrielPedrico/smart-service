package com.smartservice.adapter.http.spring.dto.saida.pedido;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"nome","quantidade"})
public class ProdutoResponse {

    private String nome;
    private String quantidade;

    public ProdutoResponse(String nome, String quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public String getQuantidade() {
        return quantidade;
    }
}
