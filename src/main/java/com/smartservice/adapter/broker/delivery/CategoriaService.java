package com.smartservice.adapter.broker.delivery;

import com.smartservice.core.port.entrada.CadastraCategoriaPort;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private final CadastraCategoriaPort cadastraCategoriaPort;

    public CategoriaService(CadastraCategoriaPort cadastraCategoriaPort) {
        this.cadastraCategoriaPort = cadastraCategoriaPort;
    }

    public CadastraCategoriaPort cadastraCategoriaPort() {
        return cadastraCategoriaPort;
    }
}
