package com.smartservice.core.biz.produto;

import com.smartservice.adapter.http.spring.dto.saida.produto.ConsultaProdutoResponse;
import com.smartservice.adapter.http.spring.dto.saida.produto.ConsultaProdutosResponse;
import com.smartservice.config.annotations.AdapterUseCase;
import com.smartservice.core.port.entrada.produto.ConsultaProdutosPort;

@AdapterUseCase
public class ConsultaProdutoBusiness implements ConsultaProdutosPort {

    private final com.smartservice.core.port.saida.produto.ConsultaProdutosPort consultaProdutosPort;

    public ConsultaProdutoBusiness(com.smartservice.core.port.saida.produto.ConsultaProdutosPort consultaProdutosPort) {
        this.consultaProdutosPort = consultaProdutosPort;
    }

    public ConsultaProdutosResponse consultaProdutos(){
        return consultaProdutosPort.consultaProdutos();
    }

    @Override
    public ConsultaProdutosResponse consultaPorCategoria(String categoria) {
        categoria.toUpperCase().replace(" ","_");
        return consultaProdutosPort.consultaPorCategoria(categoria);
    }

    @Override
    public ConsultaProdutoResponse consultaPorId(String id) {
        return consultaProdutosPort.consultaPorId(id);
    }
}
