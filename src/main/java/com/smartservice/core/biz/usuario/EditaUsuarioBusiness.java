package com.smartservice.core.biz.usuario;

import com.smartservice.config.annotations.AdapterUseCase;
import com.smartservice.core.model.usuario.UsuarioModel;
import com.smartservice.core.port.entrada.usuario.UsuarioEditaPort;
import com.smartservice.core.port.saida.usuario.EditaUsuarioPort;
import com.smartservice.core.port.saida.external.EmailSendPort;

import javax.mail.MessagingException;

@AdapterUseCase
public class EditaUsuarioBusiness implements UsuarioEditaPort {

    private final EmailSendPort emailSendPort;

    private final EditaUsuarioPort editaUsuarioPort;

    public EditaUsuarioBusiness(EmailSendPort emailSendPort,EditaUsuarioPort editaUsuarioPort) {
        this.emailSendPort = emailSendPort;
        this.editaUsuarioPort = editaUsuarioPort;
    }

    @Override
    public void resetarSenha(String email) throws MessagingException {
        emailSendPort.sendResetEmail(email);
    }

    @Override
    public void editaUsuario(UsuarioModel usuarioModel,String email) {
        editaUsuarioPort.crudUpdateUsuario(usuarioModel,email);
    }
}
