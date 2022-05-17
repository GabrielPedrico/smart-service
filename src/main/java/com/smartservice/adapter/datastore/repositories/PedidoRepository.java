package com.smartservice.adapter.datastore.repositories;

import com.smartservice.adapter.datastore.entities.Pedido;
import com.smartservice.core.model.enums.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PedidoRepository extends JpaRepository<Pedido,String> {

    List<Pedido> findByStatusPedido(StatusPedido statusPedido);
}
