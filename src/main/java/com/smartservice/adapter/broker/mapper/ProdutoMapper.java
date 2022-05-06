package com.smartservice.adapter.broker.mapper;

import com.smartservice.adapter.datastore.entities.Produto;
import com.smartservice.adapter.http.dto.entrada.produto.CadastraProdutoRequest;
import com.smartservice.config.general.ModelMapperConfig;
import com.smartservice.core.model.enums.Categoria;
import com.smartservice.core.model.usuario.ProdutoModel;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProdutoMapper {


    private final ModelMapperConfig modelMapper;

    public ProdutoMapper(ModelMapperConfig modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Produto converterParaProduto(ProdutoModel produtoModel){
        return new Produto(produtoModel.getId(),produtoModel.getCategoria(),produtoModel.getNome(),produtoModel.getPreco(),produtoModel.getDescricao(),produtoModel.getEstoque(),produtoModel.getImgUrl());
    }

    public ProdutoModel converterParaProdutoModel(CadastraProdutoRequest cadastraProdutoRequest){
        Categoria categoria = Categoria.valueOf(cadastraProdutoRequest.getCategoria());
        BigDecimal preco = new BigDecimal(cadastraProdutoRequest.getPreco());
        Integer estoque = Integer.parseInt(cadastraProdutoRequest.getEstoque());
        return new ProdutoModel(null,categoria,cadastraProdutoRequest.getNome(),preco,cadastraProdutoRequest.getDescricao(),estoque,null);
    }

    public ModelMapperConfig getModelMapper() {
        return modelMapper;
    }
}
