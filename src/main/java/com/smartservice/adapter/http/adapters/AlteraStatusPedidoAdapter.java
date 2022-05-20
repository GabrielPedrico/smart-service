package com.smartservice.adapter.http.adapters;

import com.smartservice.adapter.datastore.entities.Pedido;
import com.smartservice.adapter.datastore.repositories.PedidoRepository;
import com.smartservice.core.exceptions.AlteraStatusInconsistenciaException;
import com.smartservice.core.exceptions.PedidoNaoExistenteException;
import com.smartservice.core.model.enums.StatusPedido;
import com.smartservice.core.port.saida.AlteraStatusPedidoPort;
import com.smartservice.core.port.saida.EmailSendPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.time.LocalDateTime;

@Component
public class AlteraStatusPedidoAdapter implements AlteraStatusPedidoPort {

    @Autowired
    PedidoRepository pedidoRepository;
    @Autowired
    EmailSendPort emailSendPort;


    @Override
    public void alteraStatusDB(String idPedido, StatusPedido status) throws MessagingException {
        Pedido possivelPedido = pedidoRepository.findById(idPedido).orElseThrow(()->new PedidoNaoExistenteException("Pedido inexistente na nossa base de dados."));
        Pedido pedido = possivelPedido;
        if(pedido.getStatusPedido().equals(StatusPedido.CONCLUIDO) || pedido.getStatusPedido().equals(StatusPedido.CANCELADO)) throw new AlteraStatusInconsistenciaException("Não é possível alterar o status de um pedido que ja esteja CONCLUIDO/CANCELADO");
        pedido.setStatusPedido(status);

        if(status.equals(StatusPedido.PREPARANDO)) emailSendPort.sendPedidoEmPreparoEmail(pedido);

        if(status.equals(StatusPedido.ENTREGANDO)) emailSendPort.sendPedidoSaiuEntregaEmail(pedido);

        if(status.equals(StatusPedido.CONCLUIDO)){
            pedido.setDataFinalizacaoPedido(LocalDateTime.now());
        }

        pedidoRepository.save(pedido);

    }
}
