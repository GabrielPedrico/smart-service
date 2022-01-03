package com.smartservice.adapter.http.adapters;

import com.smartservice.adapter.datastore.entities.Produto;
import com.smartservice.adapter.datastore.repositories.ProdutoRepository;
import com.smartservice.core.port.saida.ConsultaProdutosPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsultaProdutosAdapter implements ConsultaProdutosPort {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<Produto> consultaProdutos() {
        var produtos = produtoRepository.findAll();
        return produtos;
    }
}
