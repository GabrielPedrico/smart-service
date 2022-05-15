package com.smartservice.core.port.entrada;

import com.smartservice.adapter.http.dto.saida.produto.CadastraProdutoResponse;
import com.smartservice.core.model.produto.ProdutoModel;

public interface CadastroProdutoPort {

    CadastraProdutoResponse processaCadastro(ProdutoModel produtoModel);
}
