package com.smartservice.core.port.saida.pedido;

import com.smartservice.core.model.enums.StatusPedido;

import javax.mail.MessagingException;

public interface AlteraStatusPedidoPort {

    void alteraStatusDB(String idProduto, StatusPedido status) throws MessagingException;
}
