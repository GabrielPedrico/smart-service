package com.smartservice.core.port.entrada;

import javax.mail.MessagingException;

public interface AlteraStatusPedidoPort {

    void alteraStatus(String idPedido,String status) throws MessagingException;

}
