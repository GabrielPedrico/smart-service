package com.smartservice.adapter.http.adapters.produto;

import com.smartservice.adapter.datastore.entities.Categoria;
import com.smartservice.adapter.datastore.entities.Produto;
import com.smartservice.adapter.datastore.repositories.CategoriaRepository;
import com.smartservice.adapter.datastore.repositories.ProdutoRepository;
import com.smartservice.adapter.http.spring.dto.saida.produto.ConsultaProdutoResponse;
import com.smartservice.adapter.http.spring.dto.saida.produto.ConsultaProdutosResponse;
import com.smartservice.core.exceptions.CategoriaNaoExistenteException;
import com.smartservice.core.exceptions.ProdutoNaoExistenteException;
import com.smartservice.core.port.saida.produto.ConsultaProdutosPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsultaProdutosAdapter implements ConsultaProdutosPort {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public ConsultaProdutosResponse consultaProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        ConsultaProdutosResponse produtosResponse = new ConsultaProdutosResponse();
        for (Produto produto: produtos
             ) {
            ConsultaProdutoResponse produtoResponse = new ConsultaProdutoResponse(produto.getId(),produto.getCategoria().getNome(),produto.getNome(),produto.getPreco(),produto.getDescricao(),produto.getEstoque(),produto.getImgUrl());
            produtosResponse.getProdutos().add(produtoResponse);
        }
        return produtosResponse;
    }

    @Override
    public ConsultaProdutosResponse consultaPorCategoria(String categoria)  {
        Categoria possivelCategoria = categoriaRepository.findByNome(categoria).orElseThrow(()-> new CategoriaNaoExistenteException("Categoria inexistente"));
        List<Produto> produtos = produtoRepository.findByCategoria(possivelCategoria);
        ConsultaProdutosResponse produtosResponse = new ConsultaProdutosResponse();
        for (Produto produto: produtos
        ) {
            ConsultaProdutoResponse produtoResponse = new ConsultaProdutoResponse(produto.getId(),produto.getCategoria().getNome(),produto.getNome(),produto.getPreco(),produto.getDescricao(),produto.getEstoque(),produto.getImgUrl());
            produtosResponse.getProdutos().add(produtoResponse);
        }
        return produtosResponse;
    }

    @Override
    public ConsultaProdutoResponse consultaPorId(String id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(()-> new ProdutoNaoExistenteException("Produto não existe."));
        return new ConsultaProdutoResponse(produto.getId(),produto.getCategoria().getNome(),produto.getNome(),produto.getPreco(),produto.getDescricao(),produto.getEstoque(),produto.getImgUrl());
    }


}
