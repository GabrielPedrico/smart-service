package com.smartservice.core.biz.pedido;

import com.smartservice.adapter.http.spring.dto.saida.pedido.CadastraPedidoResponse;
import com.smartservice.config.annotations.AdapterUseCase;
import com.smartservice.core.model.pedido.PedidoModel;
import com.smartservice.core.port.entrada.pedido.CadastraPedidoPort;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

@AdapterUseCase
public class CadastraPedidoBusiness implements CadastraPedidoPort {

    private final com.smartservice.core.port.saida.pedido.CadastraPedidoPort cadastraPedidoPort;


    public CadastraPedidoBusiness(com.smartservice.core.port.saida.pedido.CadastraPedidoPort cadastraPedidoPort) {
        this.cadastraPedidoPort = cadastraPedidoPort;
    }

    @Override
    public CadastraPedidoResponse cadastraPedidoDelivery(PedidoModel pedidoModel) throws MessagingException, URISyntaxException, UnsupportedEncodingException {
        return cadastraPedidoPort.cadastraPedidoDeliveryDB(pedidoModel);
    }

    @Override
    public CadastraPedidoResponse cadastraPedidoPresencial(PedidoModel pedidoModel,String qrCode) throws MessagingException, URISyntaxException, UnsupportedEncodingException {
        return cadastraPedidoPort.cadastraPedidoPresencialDB(pedidoModel,qrCode);
    }
}
