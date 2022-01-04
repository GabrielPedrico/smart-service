package com.smartservice.core.port.saida;

import com.smartservice.adapter.datastore.entities.Produto;
import com.smartservice.adapter.http.dto.saida.produto.CadastraProdutoResponse;

public interface CadastroProdutoPort {

    CadastraProdutoResponse cadastraProduto(Produto produto);
}
