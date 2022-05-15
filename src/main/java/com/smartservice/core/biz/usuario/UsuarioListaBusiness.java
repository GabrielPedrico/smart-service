package com.smartservice.core.biz.usuario;

import com.smartservice.adapter.http.dto.saida.usuario.ListaUsuarioResponse;
import com.smartservice.config.annotations.AdapterUseCase;
import com.smartservice.core.port.entrada.UsuarioListaPort;

@AdapterUseCase
public class UsuarioListaBusiness implements UsuarioListaPort {

    private final com.smartservice.core.port.saida.UsuarioListaPort usuarioListaPort;

    public UsuarioListaBusiness(com.smartservice.core.port.saida.UsuarioListaPort usuarioListaPort) {
        this.usuarioListaPort = usuarioListaPort;
    }

    @Override
    public ListaUsuarioResponse listaUsuario(String id) {
        return usuarioListaPort.resgataUsuarioDB(id);
    }
}
