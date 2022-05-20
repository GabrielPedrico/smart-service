package com.smartservice.core.port.entrada.produto;

import com.smartservice.core.model.produto.ProdutoModel;

import java.util.List;

public interface DeletaProdutoPort {

    void delete(String idProduto);

    void deleteProdutos(List<ProdutoModel> produtos);
}
