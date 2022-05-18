package com.smartservice.core.port.entrada;

import com.smartservice.adapter.http.dto.saida.pedido.CadastraPedidoResponse;
import com.smartservice.core.model.pedido.PedidoModel;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

public interface CadastraPedidoPort {

    CadastraPedidoResponse cadastraPedidoDelivery(PedidoModel pedidoModel) throws MessagingException, URISyntaxException, UnsupportedEncodingException;
    CadastraPedidoResponse cadastraPedidoPresencial(PedidoModel pedidoModel,String qrCode) throws MessagingException, URISyntaxException, UnsupportedEncodingException;
}
