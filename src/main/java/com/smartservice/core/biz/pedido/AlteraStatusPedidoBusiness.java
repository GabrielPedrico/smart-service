package com.smartservice.core.biz.pedido;

import com.smartservice.config.annotations.AdapterUseCase;
import com.smartservice.core.exceptions.StatusPedidoNaoExistenteException;
import com.smartservice.core.model.enums.StatusPedido;
import com.smartservice.core.port.entrada.pedido.AlteraStatusPedidoPort;

import javax.mail.MessagingException;
import java.util.Optional;

@AdapterUseCase
public class AlteraStatusPedidoBusiness implements AlteraStatusPedidoPort {


    private final com.smartservice.core.port.saida.pedido.AlteraStatusPedidoPort alteraStatusPedidoPort;

    public AlteraStatusPedidoBusiness(com.smartservice.core.port.saida.pedido.AlteraStatusPedidoPort alteraStatusPedidoPort) {
        this.alteraStatusPedidoPort = alteraStatusPedidoPort;
    }

    @Override
    public void alteraStatus(String idPedido, String status) throws MessagingException {
        StatusPedido possivelStatus = Optional.of(StatusPedido.valueOf(status)).orElseThrow(()-> new StatusPedidoNaoExistenteException("Status de pedido inexistente, favor consultar documentação."));
        alteraStatusPedidoPort.alteraStatusDB(idPedido,possivelStatus);
    }
}
