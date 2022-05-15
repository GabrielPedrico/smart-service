package com.smartservice.adapter.http.adapters;

import com.smartservice.adapter.datastore.entities.Categoria;
import com.smartservice.adapter.datastore.entities.Produto;
import com.smartservice.adapter.datastore.repositories.CategoriaRepository;
import com.smartservice.adapter.datastore.repositories.ProdutoRepository;
import com.smartservice.adapter.http.dto.saida.produto.CadastraProdutoResponse;
import com.smartservice.core.exceptions.CategoriaNaoExistenteException;
import com.smartservice.core.port.saida.CadastroProdutoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CadastroProdutoAdapter implements CadastroProdutoPort {


    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public CadastraProdutoResponse cadastraProduto(Produto produto) {
        Optional<Categoria> possivelCategoria =categoriaRepository.findByNome(produto.getCategoria().getNome());
        if(possivelCategoria.isEmpty()) throw new CategoriaNaoExistenteException("Categoria inexiste, falha ao cadastrar produto.");
        produto.setCategoria(possivelCategoria.get());
        produtoRepository.save(produto);
        return new CadastraProdutoResponse(produto.getId());
    }
}
