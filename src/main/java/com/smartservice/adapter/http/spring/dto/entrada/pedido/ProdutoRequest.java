package com.smartservice.adapter.http.spring.dto.entrada.pedido;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProdutoRequest {

    @JsonProperty("id_produto")
    private String idProduto;

    private Integer quantidade;

    @Override
    public String toString() {
        return "ProdutoRequest{" +
                "idProduto='" + idProduto + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }

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
