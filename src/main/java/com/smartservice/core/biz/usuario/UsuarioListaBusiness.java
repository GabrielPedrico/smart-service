package com.smartservice.core.biz.usuario;

import com.smartservice.adapter.http.spring.dto.saida.usuario.ListaUsuarioResponse;
import com.smartservice.config.annotations.AdapterUseCase;
import com.smartservice.core.port.entrada.usuario.UsuarioListaPort;

@AdapterUseCase
public class UsuarioListaBusiness implements UsuarioListaPort {

    private final com.smartservice.core.port.saida.usuario.UsuarioListaPort usuarioListaPort;

    public UsuarioListaBusiness(com.smartservice.core.port.saida.usuario.UsuarioListaPort usuarioListaPort) {
        this.usuarioListaPort = usuarioListaPort;
    }

    @Override
    public ListaUsuarioResponse listaUsuario(String id) {
        return usuarioListaPort.resgataUsuarioDB(id);
    }
}
