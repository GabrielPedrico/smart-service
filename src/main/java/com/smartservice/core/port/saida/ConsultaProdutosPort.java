package com.smartservice.core.port.saida;

import com.smartservice.adapter.datastore.entities.Produto;
import com.smartservice.adapter.http.dto.saida.produto.ConsultaProdutoResponse;
import com.smartservice.adapter.http.dto.saida.produto.ConsultaProdutosResponse;

import java.util.List;

public interface ConsultaProdutosPort {

    ConsultaProdutosResponse consultaProdutos();

    ConsultaProdutosResponse consultaPorCategoria(String categoria);

    ConsultaProdutoResponse consultaPorId(String id);


}
