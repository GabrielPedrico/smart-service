package com.smartservice.core.port.entrada.usuario;

import com.smartservice.adapter.http.spring.dto.saida.usuario.ListaUsuarioResponse;

public interface UsuarioListaPort {

    ListaUsuarioResponse listaUsuario(String id);
}
