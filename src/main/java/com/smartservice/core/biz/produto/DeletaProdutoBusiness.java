package com.smartservice.core.biz.produto;

import com.smartservice.config.annotations.AdapterUseCase;
import com.smartservice.core.model.produto.ProdutoModel;
import com.smartservice.core.port.entrada.DeletaProdutoPort;

import java.util.List;

@AdapterUseCase
public class DeletaProdutoBusiness implements DeletaProdutoPort {

    public final com.smartservice.core.port.saida.DeletaProdutoPort deletaProdutoPort;

    public DeletaProdutoBusiness(com.smartservice.core.port.saida.DeletaProdutoPort deletaProdutoPort) {
        this.deletaProdutoPort = deletaProdutoPort;
    }

    @Override
    public void delete(String idProduto) {
        deletaProdutoPort.deleteCrud(idProduto);
    }

    @Override
    public void deleteProdutos(List<ProdutoModel> produtos) {
        deletaProdutoPort.deleteProdutosCrud(produtos);
    }
}
