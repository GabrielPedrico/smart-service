package com.smartservice.adapter.datastore.repositories;

import com.smartservice.adapter.datastore.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}
