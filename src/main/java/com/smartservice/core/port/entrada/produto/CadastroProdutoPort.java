package com.smartservice.core.port.entrada.produto;

import com.smartservice.adapter.http.spring.dto.saida.produto.CadastraProdutoResponse;
import com.smartservice.core.model.produto.ProdutoModel;

public interface CadastroProdutoPort {

    CadastraProdutoResponse processaCadastro(ProdutoModel produtoModel);
}
