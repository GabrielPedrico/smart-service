package com.smartservice.adapter.http.adapters;

import com.smartservice.adapter.datastore.entities.Produto;
import com.smartservice.adapter.datastore.repositories.ProdutoRepository;
import com.smartservice.core.port.saida.CadastroProdutoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastroProdutoAdapter implements CadastroProdutoPort {


    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void cadastraProduto(Produto produto) {
        produtoRepository.save(produto);
    }
}
