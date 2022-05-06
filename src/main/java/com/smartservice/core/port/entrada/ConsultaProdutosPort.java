package com.smartservice.core.port.entrada;

import com.smartservice.adapter.datastore.entities.Produto;

import java.util.List;

public interface ConsultaProdutosPort {

    List<Produto> consultaProdutos();

    List<Produto> consultaPorCategoria(String categoria);

    Produto consultaPorId(String id);

}
