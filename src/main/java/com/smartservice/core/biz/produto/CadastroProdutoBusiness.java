package com.smartservice.core.biz.produto;

import com.smartservice.adapter.broker.mapper.ProdutoMapper;
import com.smartservice.adapter.datastore.entities.Produto;
import com.smartservice.adapter.http.dto.saida.produto.CadastraProdutoResponse;
import com.smartservice.config.annotations.AdapterUseCase;
import com.smartservice.core.model.usuario.ProdutoModel;
import com.smartservice.core.port.entrada.CadastroProdutoPort;

@AdapterUseCase
public class CadastroProdutoBusiness implements CadastroProdutoPort {


    public final com.smartservice.core.port.saida.CadastroProdutoPort cadastroProdutoPortSaida;

    public final ProdutoMapper produtoMapper;

    public CadastroProdutoBusiness(com.smartservice.core.port.saida.CadastroProdutoPort cadastroProdutoPortSaida, ProdutoMapper produtoMapper) {
        this.cadastroProdutoPortSaida = cadastroProdutoPortSaida;
        this.produtoMapper = produtoMapper;
    }

    @Override
    public CadastraProdutoResponse processaCadastro(ProdutoModel produtoModel) {
        Produto produto = produtoMapper.converterParaProduto(produtoModel);
        return cadastroProdutoPortSaida.cadastraProduto(produto);
    }
}
