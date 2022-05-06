package com.smartservice.adapter.broker.delivery;

import com.smartservice.adapter.broker.mapper.ProdutoMapper;
import com.smartservice.core.port.entrada.CadastroProdutoPort;
import com.smartservice.core.port.saida.AdicionaImagemProdutoPort;
import com.smartservice.core.port.entrada.ConsultaProdutosPort;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final CadastroProdutoPort cadastroProdutoPort;

    private final ConsultaProdutosPort consultaProdutosPort;

    private final AdicionaImagemProdutoPort adicionaImagemProdutoPort;

    private final ProdutoMapper produtoMapper;

    public ProdutoService(CadastroProdutoPort cadastroProdutoPort, ConsultaProdutosPort consultaProdutosPort, AdicionaImagemProdutoPort adicionaImagemProdutoPort, ProdutoMapper produtoMapper) {
        this.cadastroProdutoPort = cadastroProdutoPort;
        this.consultaProdutosPort = consultaProdutosPort;
        this.adicionaImagemProdutoPort = adicionaImagemProdutoPort;
        this.produtoMapper = produtoMapper;
    }

    public CadastroProdutoPort cadastroProdutoPort() {
        return cadastroProdutoPort;
    }

    public ConsultaProdutosPort consultaProdutosPort() {
        return consultaProdutosPort;
    }

    public AdicionaImagemProdutoPort adicionaImagemProdutoPort() {
        return adicionaImagemProdutoPort;
    }

    public ProdutoMapper produtoMapper() {
        return produtoMapper;
    }
}
