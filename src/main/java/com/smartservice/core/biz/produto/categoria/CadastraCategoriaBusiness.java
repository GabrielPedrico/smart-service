package com.smartservice.core.biz.produto.categoria;

import com.smartservice.config.annotations.AdapterUseCase;
import com.smartservice.core.port.entrada.produto.categoria.CadastraCategoriaPort;

@AdapterUseCase
public class CadastraCategoriaBusiness implements CadastraCategoriaPort {

    private final com.smartservice.core.port.saida.categoria.CadastraCategoriaPort cadastraCategoriaPort;

    public CadastraCategoriaBusiness(com.smartservice.core.port.saida.categoria.CadastraCategoriaPort cadastraCategoriaPort) {
        this.cadastraCategoriaPort = cadastraCategoriaPort;
    }

    @Override
    public void cadastra(String categoria) {
        cadastraCategoriaPort.cadastraCategoriaCrud(categoria);
    }
}
