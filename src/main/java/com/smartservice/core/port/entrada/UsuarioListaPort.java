package com.smartservice.core.port.entrada;

import com.smartservice.adapter.http.dto.saida.usuario.ListaUsuarioResponse;

public interface UsuarioListaPort {

    ListaUsuarioResponse listaUsuario(String id);
}
