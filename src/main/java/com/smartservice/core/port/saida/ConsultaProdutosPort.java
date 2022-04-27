package com.smartservice.core.port.saida;

import com.smartservice.adapter.datastore.entities.Produto;

import java.util.List;
import java.util.Optional;

public interface ConsultaProdutosPort {

    List<Produto> consultaProdutos();

    List<Produto> consultaPorCategoria(String categoria);

    Optional<Produto> consultaPorId(String id);


}
