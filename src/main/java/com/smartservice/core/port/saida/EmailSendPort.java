package com.smartservice.core.port.saida;

import com.smartservice.adapter.datastore.entities.Pedido;
import com.smartservice.adapter.datastore.entities.Usuario;

import javax.mail.MessagingException;

public interface EmailSendPort {

    void sendResetEmail(String emailDestino) throws MessagingException;

    void sendPedidoEmail(Usuario usuario, Pedido pedido,String msgWpp) throws MessagingException;
}
