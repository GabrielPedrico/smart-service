package com.smartservice.adapter.http.adapters;

import com.smartservice.adapter.datastore.entities.Categoria;
import com.smartservice.adapter.datastore.entities.Produto;
import com.smartservice.adapter.datastore.repositories.CategoriaRepository;
import com.smartservice.adapter.datastore.repositories.ProdutoRepository;
import com.smartservice.core.exceptions.CategoriaNaoExistenteException;
import com.smartservice.core.exceptions.ProdutoNaoExistenteException;
import com.smartservice.core.port.saida.ConsultaProdutosPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ConsultaProdutosAdapter implements ConsultaProdutosPort {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Produto> consultaProdutos() {
        var produtos = produtoRepository.findAll();
        return produtos;
    }

    @Override
    public List<Produto> consultaPorCategoria(String categoria)  {
        Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(categoria);
        if(possivelCategoria.isEmpty()) throw new CategoriaNaoExistenteException("Categoria inexistente");
        List<Produto> produtos = produtoRepository.findByCategoria(possivelCategoria.get());
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
