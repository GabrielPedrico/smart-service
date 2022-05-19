package com.smartservice.adapter.broker.mapper;

import com.smartservice.adapter.datastore.entities.Categoria;
import com.smartservice.adapter.datastore.entities.Produto;
import com.smartservice.adapter.http.dto.entrada.produto.CadastraProdutoRequest;
import com.smartservice.adapter.http.dto.entrada.produto.DeletaProdutoRequest;
import com.smartservice.adapter.http.dto.entrada.produto.DeletaProdutosRequest;
import com.smartservice.adapter.http.dto.entrada.produto.EditaProdutoRequest;
import com.smartservice.config.general.ModelMapperConfig;
import com.smartservice.core.model.produto.ProdutoModel;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoMapper {


    private final ModelMapperConfig modelMapper;

    public ProdutoMapper(ModelMapperConfig modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Produto converterParaProduto(ProdutoModel produtoModel){
        return new Produto(produtoModel.getId(),new Categoria(null,produtoModel.getCategoria()),produtoModel.getNome(),produtoModel.getPreco(),produtoModel.getDescricao(),produtoModel.getEstoque(),produtoModel.getImgUrl(),null,null);
    }

    public ProdutoModel converterParaProdutoModel(CadastraProdutoRequest cadastraProdutoRequest){
        BigDecimal preco = new BigDecimal(cadastraProdutoRequest.getPreco());
        Integer estoque = Integer.parseInt(cadastraProdutoRequest.getEstoque());
        return new ProdutoModel(null,cadastraProdutoRequest.getCategoria(),cadastraProdutoRequest.getNome(),preco,cadastraProdutoRequest.getDescricao(),estoque,null);
    }

    public ProdutoModel converterParaProdutoModel(EditaProdutoRequest cadastraProdutoRequest,String id){
        BigDecimal preco = null;
        Integer estoque=null;

        if(!cadastraProdutoRequest.getPreco().isBlank()) preco = new BigDecimal(cadastraProdutoRequest.getPreco());
        if(!cadastraProdutoRequest.getEstoque().isBlank()) estoque = Integer.parseInt(cadastraProdutoRequest.getEstoque());

        return new ProdutoModel(id,cadastraProdutoRequest.getCategoria(),cadastraProdutoRequest.getNome(),preco,cadastraProdutoRequest.getDescricao(),estoque,null);
    }

    public List<ProdutoModel> converterParaListaDeProdutoModel(DeletaProdutosRequest produtos){
       List<ProdutoModel> listaProdutoModel = new ArrayList<>();
        for (DeletaProdutoRequest produto:produtos.getProdutos()
             )
        {
                ProdutoModel produtoModel = new ProdutoModel(produto.getIdProduto());
                listaProdutoModel.add(produtoModel);
        }
        return listaProdutoModel;
    }

    public ModelMapperConfig getModelMapper() {
        return modelMapper;
    }
}
