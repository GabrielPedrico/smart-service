package com.smartservice.core.port.saida.produto;

import com.smartservice.adapter.http.spring.dto.saida.produto.ConsultaProdutoResponse;
import com.smartservice.adapter.http.spring.dto.saida.produto.ConsultaProdutosResponse;

public interface ConsultaProdutosPort {

    ConsultaProdutosResponse consultaProdutos(Integer page);

    ConsultaProdutosResponse consultaPorCategoria(String categoria);

    ConsultaProdutoResponse consultaPorId(String id);


}
