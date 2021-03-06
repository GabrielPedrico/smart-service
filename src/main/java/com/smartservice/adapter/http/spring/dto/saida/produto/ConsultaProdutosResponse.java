package com.smartservice.adapter.http.spring.dto.saida.produto;

import java.util.ArrayList;
import java.util.List;

public class ConsultaProdutosResponse {

    private List<ConsultaProdutoResponse> produtos = new ArrayList<>();

    public ConsultaProdutosResponse(List<ConsultaProdutoResponse> produtos) {
        this.produtos = produtos;
    }

    public ConsultaProdutosResponse() {
    }

    public List<ConsultaProdutoResponse> getProdutos() {
        return produtos;
    }
}
