package com.smartservice.core.port.entrada;

import com.smartservice.adapter.http.dto.entrada.produto.DeletaProdutoRequest;
import com.smartservice.core.model.produto.ProdutoModel;

import java.util.List;

public interface DeletaProdutoPort {

    void delete(String idProduto);

    void deleteProdutos(List<ProdutoModel> produtos);
}
