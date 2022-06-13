package com.smartservice.core.port.entrada.pedido;

import javax.mail.MessagingException;

public interface AlteraStatusPedidoPort {

    void alteraStatus(String idPedido,String status) throws MessagingException;

}
