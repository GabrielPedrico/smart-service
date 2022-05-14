package com.smartservice.adapter.broker.delivery;

import com.smartservice.adapter.broker.mapper.PedidoMapper;
import com.smartservice.core.port.entrada.CadastraPedidoPort;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final CadastraPedidoPort cadastraPedidoPort;

    private final PedidoMapper pedidoMapper;

    public PedidoService(CadastraPedidoPort cadastraPedidoPort, PedidoMapper pedidoMapper) {
        this.cadastraPedidoPort = cadastraPedidoPort;
        this.pedidoMapper = pedidoMapper;
    }

    public CadastraPedidoPort cadastraPedidoPort() {
        return cadastraPedidoPort;
    }

    public PedidoMapper pedidoMapper() {
        return pedidoMapper;
    }
}
