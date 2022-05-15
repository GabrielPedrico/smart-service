package com.smartservice.core.biz.produto;

import com.smartservice.adapter.datastore.entities.Produto;
import com.smartservice.config.annotations.AdapterUseCase;
import com.smartservice.core.port.entrada.ConsultaProdutosPort;

import java.util.List;

@AdapterUseCase
public class ConsultaProdutoBusiness implements ConsultaProdutosPort {

    private final com.smartservice.core.port.saida.ConsultaProdutosPort consultaProdutosPort;

    public ConsultaProdutoBusiness(com.smartservice.core.port.saida.ConsultaProdutosPort consultaProdutosPort) {
        this.consultaProdutosPort = consultaProdutosPort;
    }

    public List<Produto> consultaProdutos(){
        List<Produto> produtos =  consultaProdutosPort.consultaProdutos();
        return produtos;
    }

    @Override
    public List<Produto> consultaPorCategoria(String categoria) {
        categoria.toUpperCase().replace(" ","_");
        return consultaProdutosPort.consultaPorCategoria(categoria);
    }

    @Override
    public Produto consultaPorId(String id) {
        return consultaProdutosPort.consultaPorId(id);
    }
}
