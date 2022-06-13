package com.smartservice.core.port.saida.pedido;

import com.smartservice.adapter.http.spring.dto.saida.pedido.CadastraPedidoResponse;
import com.smartservice.core.model.pedido.PedidoModel;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

public interface CadastraPedidoPort {

    CadastraPedidoResponse cadastraPedidoDeliveryDB(PedidoModel pedidoModel) throws MessagingException, URISyntaxException, UnsupportedEncodingException;
    CadastraPedidoResponse cadastraPedidoPresencialDB(PedidoModel pedidoModel,String qrCode) throws MessagingException, URISyntaxException, UnsupportedEncodingException;

}
