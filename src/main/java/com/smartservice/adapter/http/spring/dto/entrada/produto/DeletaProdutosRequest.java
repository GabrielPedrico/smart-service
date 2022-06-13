package com.smartservice.adapter.http.spring.dto.entrada.produto;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class DeletaProdutosRequest {

    @NotEmpty
    List<DeletaProdutoRequest> produtos;

    public DeletaProdutosRequest(List<DeletaProdutoRequest> produtos) {
        this.produtos = produtos;
    }
    @Deprecated
    public DeletaProdutosRequest(){}

    public List<DeletaProdutoRequest> getProdutos() {
        return produtos;
    }

    @Override
    public String toString() {
        return "DeletaProdutosRequest{" +
                "produtos=" + produtos +
                '}';
    }
}
