package com.smartservice.adapter.http.dto.saida.produto;

import com.smartservice.adapter.datastore.entities.Produto;

import java.util.List;

public class ConsultaProdutoResponse {

    private List<Produto> produtos;

    public ConsultaProdutoResponse(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public ConsultaProdutoResponse() {
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
