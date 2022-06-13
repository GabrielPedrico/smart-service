package com.smartservice.core.biz.produto.categoria;

import com.smartservice.config.annotations.AdapterUseCase;
import com.smartservice.core.port.entrada.produto.categoria.EditaCategoriaPort;

@AdapterUseCase
public class EditaCategoriaBusiness implements EditaCategoriaPort {

    private final com.smartservice.core.port.saida.categoria.EditaCategoriaPort editaCategoriaPort;

    public EditaCategoriaBusiness(com.smartservice.core.port.saida.categoria.EditaCategoriaPort editaCategoriaPort) {
        this.editaCategoriaPort = editaCategoriaPort;
    }

    @Override
    public void edita(String categoria, String categoriaEditada) {
        editaCategoriaPort.editaCategoriaCrud(categoria.toUpperCase().replace(" ","_"),
                                                categoriaEditada.toUpperCase().replace(" ","_"));
    }
}
