package com.smartservice.adapter.broker.delivery;

import com.smartservice.adapter.broker.mapper.ProdutoMapper;
import com.smartservice.core.port.entrada.CadastroProdutoPort;
import com.smartservice.core.port.entrada.DeletaProdutoPort;
import com.smartservice.core.port.saida.AdicionaImagemProdutoPort;
import com.smartservice.core.port.entrada.ConsultaProdutosPort;
import com.smartservice.core.port.saida.EditaProdutoPort;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final CadastroProdutoPort cadastroProdutoPort;

    private final ConsultaProdutosPort consultaProdutosPort;

    private final AdicionaImagemProdutoPort adicionaImagemProdutoPort;

    private final DeletaProdutoPort deletaProdutoPort;

    private final EditaProdutoPort editaProdutoPort;

    private final ProdutoMapper produtoMapper;

    public ProdutoService(CadastroProdutoPort cadastroProdutoPort, ConsultaProdutosPort consultaProdutosPort, AdicionaImagemProdutoPort adicionaImagemProdutoPort, ProdutoMapper produtoMapper,DeletaProdutoPort deletaProdutoPort,EditaProdutoPort editaProdutoPort) {
        this.editaProdutoPort = editaProdutoPort;
        this.cadastroProdutoPort = cadastroProdutoPort;
        this.consultaProdutosPort = consultaProdutosPort;
        this.adicionaImagemProdutoPort = adicionaImagemProdutoPort;
        this.produtoMapper = produtoMapper;
        this.deletaProdutoPort = deletaProdutoPort;
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

    public DeletaProdutoPort deletaProdutoPort() {
        return deletaProdutoPort;
    }

    public EditaProdutoPort editaProdutoPort() {
        return editaProdutoPort;
    }
}
