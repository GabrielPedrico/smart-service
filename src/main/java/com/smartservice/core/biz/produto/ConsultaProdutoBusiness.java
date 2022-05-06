package com.smartservice.core.biz.produto;

import com.smartservice.adapter.datastore.entities.Produto;
import com.smartservice.config.annotations.AdapterUseCase;
import com.smartservice.core.model.enums.Categoria;
import com.smartservice.core.port.saida.ConsultaProdutosPort;

import java.util.List;

@AdapterUseCase
public class ConsultaProdutoBusiness implements com.smartservice.core.port.entrada.ConsultaProdutosPort {

    private final ConsultaProdutosPort consultaProdutosPort;

    public ConsultaProdutoBusiness(ConsultaProdutosPort consultaProdutosPort) {
        this.consultaProdutosPort = consultaProdutosPort;
    }

    public List<Produto> consultaProdutos(){
        List<Produto> produtos =  consultaProdutosPort.consultaProdutos();
        return produtos;
    }

    @Override
    public List<Produto> consultaPorCategoria(String categoria) {
        Categoria.verificaExistenciaCategoria(categoria);
        return consultaProdutosPort.consultaPorCategoria(categoria);
    }

    @Override
    public Produto consultaPorId(String id) {
        return consultaProdutosPort.consultaPorId(id);
    }
}
