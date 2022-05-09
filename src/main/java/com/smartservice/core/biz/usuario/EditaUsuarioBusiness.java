package com.smartservice.core.biz.usuario;

import com.smartservice.config.annotations.AdapterUseCase;
import com.smartservice.core.port.entrada.UsuarioEditaPort;
import com.smartservice.core.port.saida.EmailSendPort;

import javax.mail.MessagingException;

@AdapterUseCase
public class EditaUsuarioBusiness implements UsuarioEditaPort {

    private final EmailSendPort emailSendPort;

    public EditaUsuarioBusiness(EmailSendPort emailSendPort) {
        this.emailSendPort = emailSendPort;
    }

    @Override
    public void resetarSenha(String email) throws MessagingException {
        emailSendPort.sendEmail(email);
    }

    @Override
    public void mudarSenha() {
        //TODO Falta criar o port de saida para acesso ao DB & implementar lógica em adapter para CRUD
    }

    @Override
    public void mudarEmail() {
        //TODO Falta criar o port de saida para acesso ao DB & implementar lógica em adapter para CRUD
    }

    @Override
    public void mudarPerfil() {
        //TODO Falta criar o port de saida para acesso ao DB & implementar lógica em adapter para CRUD
    }
}
