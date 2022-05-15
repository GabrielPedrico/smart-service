package com.smartservice.core.port.entrada;

import com.smartservice.adapter.http.dto.saida.usuario.AutenticaUsuarioResponse;

public interface UsuarioAutenticaPort {
    AutenticaUsuarioResponse autenticaUsuario(String email, String senha);
}
