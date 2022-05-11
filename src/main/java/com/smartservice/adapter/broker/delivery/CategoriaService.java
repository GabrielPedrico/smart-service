package com.smartservice.adapter.broker.delivery;

import com.smartservice.core.port.entrada.CadastraCategoriaPort;
import com.smartservice.core.port.entrada.EditaCategoriaPort;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private final CadastraCategoriaPort cadastraCategoriaPort;

    private final EditaCategoriaPort editaCategoriaPort;

    public CategoriaService(CadastraCategoriaPort cadastraCategoriaPort,EditaCategoriaPort editaCategoriaPort) {
        this.cadastraCategoriaPort = cadastraCategoriaPort;
        this.editaCategoriaPort = editaCategoriaPort;
    }

    public CadastraCategoriaPort cadastraCategoriaPort() {
        return cadastraCategoriaPort;
    }

    public EditaCategoriaPort editaCategoriaPort() {
        return editaCategoriaPort;
    }
}
