package com.smartservice.adapter.http.dto.entrada.produto;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class DeletaProdutosRequest {

    @NotEmpty
    List<DeletaProdutoRequest> produtos;

    public DeletaProdutosRequest(List<DeletaProdutoRequest> produtos) {
        this.produtos = produtos;
    }
    @Deprecated
    public DeletaProdutosRequest(){};

    public List<DeletaProdutoRequest> getProdutos() {
        return produtos;
    }
}
