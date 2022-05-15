package com.smartservice.adapter.broker.mapper;

import com.smartservice.adapter.http.dto.entrada.pedido.CadastraPedidoRequest;
import com.smartservice.adapter.http.dto.entrada.pedido.ProdutoRequest;
import com.smartservice.config.general.ModelMapperConfig;
import com.smartservice.core.model.pedido.PedidoModel;
import com.smartservice.core.model.pedido.ProdutoModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PedidoMapper {


    private final ModelMapperConfig modelMapper;

    public PedidoMapper(ModelMapperConfig modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PedidoModel converterParaPedidoModel(CadastraPedidoRequest cadastraPedidoRequest){
        List<ProdutoModel> produtos = new ArrayList<ProdutoModel>();
        for (ProdutoRequest produtoRequest:cadastraPedidoRequest.getProdutos()
             ) {
            ProdutoModel produtoModel = new ProdutoModel(produtoRequest.getIdProduto(),produtoRequest.getQuantidade());
            produtos.add(produtoModel);
        }
        return new PedidoModel(cadastraPedidoRequest.getIdUsuario(),produtos,cadastraPedidoRequest.getFormaPagamento());
    }

    public ModelMapperConfig getModelMapper() {
        return modelMapper;
    }
}