package com.smartservice.core.port.saida;

import com.smartservice.adapter.http.dto.saida.pedido.ConsultaPedidoResponse;

import java.util.List;

public interface ConsultaPedidosPort {

    ConsultaPedidoResponse consultaPedidoPorId(String idPedido);

    List<ConsultaPedidoResponse> consultaPedidosPorStatus(String status);

    List<ConsultaPedidoResponse> consultaPedidosPorUsuario(String idUsuario);
}
