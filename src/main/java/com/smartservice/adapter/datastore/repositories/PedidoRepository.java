package com.smartservice.adapter.datastore.repositories;

import com.smartservice.adapter.datastore.entities.Pedido;
import com.smartservice.adapter.datastore.entities.Usuario;
import com.smartservice.core.model.enums.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,String> {

    Optional<List<Pedido>> findByStatusPedido(StatusPedido statusPedido);

    Optional<List<Pedido>> findByUsuario(Usuario usuario);
}
