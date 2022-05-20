package com.smartservice.core.port.entrada.usuario;

import com.smartservice.adapter.http.spring.dto.saida.usuario.AutenticaUsuarioResponse;

public interface UsuarioAutenticaPort {
    AutenticaUsuarioResponse autenticaUsuario(String email, String senha);
}
