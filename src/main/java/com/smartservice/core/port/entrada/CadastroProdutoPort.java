package com.smartservice.core.port.entrada;

import com.smartservice.adapter.http.dto.saida.produto.CadastraProdutoResponse;
import com.smartservice.core.model.usuario.ProdutoModel;

public interface CadastroProdutoPort {

    CadastraProdutoResponse processaCadastro(ProdutoModel produtoModel);
}
