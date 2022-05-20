package com.smartservice.core.port.entrada.usuario;

import com.smartservice.core.model.usuario.UsuarioModel;

import javax.mail.MessagingException;

public interface UsuarioEditaPort {

    void resetarSenha(String email) throws MessagingException;

    void editaUsuario(UsuarioModel usuario,String email);
}
