package com.smartservice.core.biz.produto;

import com.smartservice.config.annotations.AdapterUseCase;
import com.smartservice.core.model.produto.ProdutoModel;
import com.smartservice.core.port.entrada.EditaProdutoPort;

@AdapterUseCase
public class EditaProdutoBusiness implements EditaProdutoPort {

    private final com.smartservice.core.port.saida.EditaProdutoPort editaProdutoPort;

    public EditaProdutoBusiness(com.smartservice.core.port.saida.EditaProdutoPort editaProdutoPort) {
        this.editaProdutoPort = editaProdutoPort;
    }

    @Override
    public void editaProduto(ProdutoModel produtoModel) {
        editaProdutoPort.editaProduto(produtoModel);
    }

    public com.smartservice.core.port.saida.EditaProdutoPort getEditaProdutoPort() {
        return editaProdutoPort;
    }
}
