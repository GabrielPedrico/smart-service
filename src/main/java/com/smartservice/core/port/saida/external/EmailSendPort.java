package com.smartservice.core.port.saida.external;

import com.smartservice.adapter.datastore.entities.Pedido;

import javax.mail.MessagingException;

public interface EmailSendPort {

    void sendResetEmail(String emailDestino) throws MessagingException;

    void sendPedidoRegistradoEmail(Pedido pedido, String msgWpp) throws MessagingException;

    void sendPedidoEmPreparoEmail(Pedido pedido) throws MessagingException;

    void sendPedidoSaiuEntregaEmail(Pedido pedido) throws MessagingException;
}
