package com.smartservice.adapter.http.adapters;

import com.smartservice.adapter.datastore.entities.Produto;
import com.smartservice.adapter.datastore.repositories.ProdutoRepository;
import com.smartservice.core.exceptions.ProdutoNaoExistenteException;
import com.smartservice.core.model.enums.Categoria;
import com.smartservice.core.port.saida.ConsultaProdutosPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ConsultaProdutosAdapter implements ConsultaProdutosPort {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<Produto> consultaProdutos() {
        var produtos = produtoRepository.findAll();
        return produtos;
    }

    @Override
    public List<Produto> consultaPorCategoria(String categoria)  {
       var produtos = produtoRepository.findByCategoria(Categoria.valueOf(categoria));
       return produtos;
    }

    @Override
    public Produto consultaPorId(String id) {
        var produto = produtoRepository.findById(id);
        if(produto.isEmpty()){
            throw new ProdutoNaoExistenteException("Produto não existe.");
        }
        return produto.get();
    }


}
