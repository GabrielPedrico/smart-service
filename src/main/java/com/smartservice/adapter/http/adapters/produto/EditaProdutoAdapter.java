package com.smartservice.adapter.http.adapters.produto;

import com.smartservice.adapter.broker.mapper.ProdutoMapper;
import com.smartservice.adapter.datastore.entities.Produto;
import com.smartservice.adapter.datastore.repositories.CategoriaRepository;
import com.smartservice.adapter.datastore.repositories.ProdutoRepository;
import com.smartservice.core.exceptions.ProdutoNaoExistenteException;
import com.smartservice.core.model.produto.ProdutoModel;
import com.smartservice.core.port.saida.produto.EditaProdutoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EditaProdutoAdapter implements EditaProdutoPort {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ProdutoMapper produtoMapper;

    @Override
    public void editaProduto(ProdutoModel produtoModel) {
        Optional<Produto> possivelProduto = produtoRepository.findById(produtoModel.getId());
        if(possivelProduto.isEmpty()) throw new ProdutoNaoExistenteException("Produto inexistente.");
        Produto produto = produtoMapper.converterParaProduto(produtoModel);

        if(produto.getCategoria().getNome().isEmpty()) produto.setCategoria(possivelProduto.get().getCategoria());
        if(!produto.getCategoria().getNome().isEmpty()) produto.setCategoria(possivelProduto.get().getCategoria());
        if(produto.getDescricao().isBlank()) produto.setDescricao(possivelProduto.get().getDescricao());
        if(produto.getNome().isBlank()) produto.setNome(possivelProduto.get().getNome());
        if(produto.getPreco() == null) produto.setPreco(possivelProduto.get().getPreco());
        if(produto.getEstoque() == null) produto.setEstoque(possivelProduto.get().getEstoque());
        produto.setImgUrl(possivelProduto.get().getImgUrl());
        produtoRepository.save(produto);

    }
}
