package com.smartservice.adapter.http.dto.entrada.pedido;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProdutoRequest {

    @JsonProperty("id_produto")
    private String idProduto;

    private Integer quantidade;

    public ProdutoRequest(String idProduto, Integer quantidade) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    @Deprecated
    public ProdutoRequest(){}

    public String getIdProduto() {
        return idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
