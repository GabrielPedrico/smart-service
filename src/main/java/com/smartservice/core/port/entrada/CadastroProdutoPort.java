package com.smartservice.core.port.entrada;

import com.smartservice.core.model.usuario.ProdutoModel;

public interface CadastroProdutoPort {

    void processaCadastro(ProdutoModel produtoModel);
}
