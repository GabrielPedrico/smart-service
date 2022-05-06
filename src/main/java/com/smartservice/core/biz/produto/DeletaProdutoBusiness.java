package com.smartservice.core.biz.produto;

import com.smartservice.config.annotations.AdapterUseCase;
import com.smartservice.core.port.entrada.DeletaProdutoPort;

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
}
