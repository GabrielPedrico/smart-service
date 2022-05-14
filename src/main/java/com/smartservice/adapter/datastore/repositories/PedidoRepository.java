package com.smartservice.adapter.datastore.repositories;

import com.smartservice.adapter.datastore.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PedidoRepository extends JpaRepository<Pedido,String> {
}
