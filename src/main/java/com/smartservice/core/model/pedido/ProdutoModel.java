package com.smartservice.core.model.pedido;

public class ProdutoModel {

    private String idProduto;

    private Integer quantidade;

    public ProdutoModel(String idProduto, Integer quantidade) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
