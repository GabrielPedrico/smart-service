package com.smartservice.core.biz.produto.categoria;

import com.smartservice.config.annotations.AdapterUseCase;
import com.smartservice.core.port.entrada.CadastraCategoriaPort;

@AdapterUseCase
public class CadastraCategoriaBusiness implements CadastraCategoriaPort {

    private final com.smartservice.core.port.saida.CadastraCategoriaPort cadastraCategoriaPort;

    public CadastraCategoriaBusiness(com.smartservice.core.port.saida.CadastraCategoriaPort cadastraCategoriaPort) {
        this.cadastraCategoriaPort = cadastraCategoriaPort;
    }

    @Override
    public void cadastra(String categoria) {
        cadastraCategoriaPort.cadastraCategoriaCrud(categoria);
    }
}
