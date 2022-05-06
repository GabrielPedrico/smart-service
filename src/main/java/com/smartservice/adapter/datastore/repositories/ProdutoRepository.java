package com.smartservice.adapter.datastore.repositories;

import com.smartservice.adapter.datastore.entities.Produto;
import com.smartservice.core.model.enums.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

    List<Produto> findByCategoria(Categoria categoria);

    //void deleteById(String id);
}
