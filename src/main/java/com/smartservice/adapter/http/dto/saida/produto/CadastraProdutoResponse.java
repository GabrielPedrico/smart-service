package com.smartservice.adapter.http.dto.saida.produto;

public class CadastraProdutoResponse {

    private String produtoId;

    public CadastraProdutoResponse(String produtoId) {
        this.produtoId = produtoId;
    }

    @Deprecated
    public CadastraProdutoResponse() {
    }

    public String getProdutoId() {
        return produtoId;
    }
}
