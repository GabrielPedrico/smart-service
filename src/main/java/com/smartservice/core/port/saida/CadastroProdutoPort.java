package com.smartservice.core.port.saida;

import com.smartservice.adapter.datastore.entities.Produto;

public interface CadastroProdutoPort {

    void cadastraProduto(Produto produto);
}
