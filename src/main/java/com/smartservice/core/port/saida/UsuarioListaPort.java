package com.smartservice.core.port.saida;

import com.smartservice.adapter.http.dto.saida.usuario.ListaUsuarioResponse;

public interface UsuarioListaPort {

    ListaUsuarioResponse resgataUsuarioDB(String id);
}
