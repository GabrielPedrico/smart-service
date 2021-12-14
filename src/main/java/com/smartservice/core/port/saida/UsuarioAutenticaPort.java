package com.smartservice.core.port.saida;

public interface UsuarioAutenticaPort {
    Boolean verificaSenha(String senhaInformada,String senhaUsuario);
}
