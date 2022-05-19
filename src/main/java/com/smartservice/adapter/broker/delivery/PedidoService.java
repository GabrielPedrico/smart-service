package com.smartservice.adapter.broker.delivery;

import com.smartservice.adapter.broker.mapper.PedidoMapper;
import com.smartservice.core.port.entrada.AlteraStatusPedidoPort;
import com.smartservice.core.port.entrada.AlteraStatusPedidoPresencialPort;
import com.smartservice.core.port.entrada.CadastraPedidoPort;
import com.smartservice.core.port.saida.ConsultaPedidosPort;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final CadastraPedidoPort cadastraPedidoPort;

    private final PedidoMapper pedidoMapper;

    private final AlteraStatusPedidoPort alteraStatusPedidoPort;

    private final AlteraStatusPedidoPresencialPort alteraStatusPedidoPresencialPort;

    private final ConsultaPedidosPort consultaPedidosPort;

    public PedidoService(CadastraPedidoPort cadastraPedidoPort, PedidoMapper pedidoMapper,AlteraStatusPedidoPort alteraStatusPedidoPort,ConsultaPedidosPort consultaPedidosPort,AlteraStatusPedidoPresencialPort alteraStatusPedidoPresencialPort) {
        this.cadastraPedidoPort = cadastraPedidoPort;
        this.pedidoMapper = pedidoMapper;
        this.alteraStatusPedidoPort = alteraStatusPedidoPort;
        this.consultaPedidosPort = consultaPedidosPort;
        this.alteraStatusPedidoPresencialPort = alteraStatusPedidoPresencialPort;
    }

    public CadastraPedidoPort cadastraPedidoPort() {
        return cadastraPedidoPort;
    }

    public PedidoMapper pedidoMapper() {
        return pedidoMapper;
    }

    public AlteraStatusPedidoPort alteraStatusPedidoPort() {
        return alteraStatusPedidoPort;
    }

    public ConsultaPedidosPort consultaPedidosPort() {
        return consultaPedidosPort;
    }

    public AlteraStatusPedidoPresencialPort alteraStatusPedidoPresencialPort() {
        return alteraStatusPedidoPresencialPort;
    }
}
