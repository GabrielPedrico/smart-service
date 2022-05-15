package com.smartservice.adapter.datastore.repositories;

import com.smartservice.adapter.datastore.entities.Categoria;
import com.smartservice.adapter.datastore.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, String> {
    List<Produto> findByCategoria(Categoria categoria);
}
