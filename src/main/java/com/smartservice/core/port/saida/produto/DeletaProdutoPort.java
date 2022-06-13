package com.smartservice.core.port.saida.produto;

import com.smartservice.core.model.produto.ProdutoModel;

import java.util.List;

public interface DeletaProdutoPort {

    void deleteCrud(String idProduto);

    void deleteProdutosCrud(List<ProdutoModel> produtos);
}
