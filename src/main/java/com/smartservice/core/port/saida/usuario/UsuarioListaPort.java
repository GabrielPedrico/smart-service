package com.smartservice.core.port.saida.usuario;

import com.smartservice.adapter.http.spring.dto.saida.usuario.ListaUsuarioResponse;

public interface UsuarioListaPort {

    ListaUsuarioResponse resgataUsuarioDB(String id);
}
