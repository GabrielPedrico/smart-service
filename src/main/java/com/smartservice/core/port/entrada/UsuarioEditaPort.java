package com.smartservice.core.port.entrada;

import javax.mail.MessagingException;

public interface UsuarioEditaPort {

    void resetarSenha(String email) throws MessagingException;

    void mudarSenha();

    void mudarEmail();

    void mudarPerfil();
}
