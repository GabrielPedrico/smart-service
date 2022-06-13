package com.smartservice.core.port.saida.usuario;

public interface UsuarioAutenticaPort {
    Boolean verificaSenha(String senhaInformada,String senhaUsuario);
}
