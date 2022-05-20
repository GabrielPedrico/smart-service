package com.smartservice.adapter.broker.delivery;

import com.smartservice.core.port.entrada.produto.categoria.CadastraCategoriaPort;
import com.smartservice.core.port.entrada.produto.categoria.EditaCategoriaPort;
import com.smartservice.core.port.saida.categoria.ConsultaCategoriasPort;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private final CadastraCategoriaPort cadastraCategoriaPort;

    private final EditaCategoriaPort editaCategoriaPort;

    private final ConsultaCategoriasPort consultaCategoriasPort;

    public CategoriaService(CadastraCategoriaPort cadastraCategoriaPort, EditaCategoriaPort editaCategoriaPort, ConsultaCategoriasPort consultaCategoriasPort) {
        this.cadastraCategoriaPort = cadastraCategoriaPort;
        this.editaCategoriaPort = editaCategoriaPort;
        this.consultaCategoriasPort = consultaCategoriasPort;
    }

    public CadastraCategoriaPort cadastraCategoriaPort() {
        return cadastraCategoriaPort;
    }

    public EditaCategoriaPort editaCategoriaPort() {
        return editaCategoriaPort;
    }

    public ConsultaCategoriasPort consultaCategoriasPort() {
        return consultaCategoriasPort;
    }
}
