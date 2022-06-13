package com.smartservice.core.port.saida.produto;

import com.smartservice.adapter.datastore.entities.Produto;
import com.smartservice.adapter.http.spring.dto.saida.produto.CadastraProdutoResponse;

public interface CadastroProdutoPort {

    CadastraProdutoResponse cadastraProduto(Produto produto);
}
