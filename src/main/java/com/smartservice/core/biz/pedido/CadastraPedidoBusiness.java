package com.smartservice.core.biz.pedido;

import com.smartservice.adapter.http.dto.saida.pedido.CadastraPedidoResponse;
import com.smartservice.config.annotations.AdapterUseCase;
import com.smartservice.core.model.pedido.PedidoModel;
import com.smartservice.core.port.entrada.CadastraPedidoPort;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

@AdapterUseCase
public class CadastraPedidoBusiness implements CadastraPedidoPort {

    private final com.smartservice.core.port.saida.CadastraPedidoPort cadastraPedidoPort;


    public CadastraPedidoBusiness(com.smartservice.core.port.saida.CadastraPedidoPort cadastraPedidoPort) {
        this.cadastraPedidoPort = cadastraPedidoPort;
    }

    @Override
    public CadastraPedidoResponse cadastra(PedidoModel pedidoModel) throws MessagingException, URISyntaxException, UnsupportedEncodingException {
        CadastraPedidoResponse response = cadastraPedidoPort.cadastraPedidoDB(pedidoModel);
        return response;
    }
}
