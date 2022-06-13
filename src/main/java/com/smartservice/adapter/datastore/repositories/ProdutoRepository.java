package com.smartservice.adapter.datastore.repositories;

import com.smartservice.adapter.datastore.entities.Categoria;
import com.smartservice.adapter.datastore.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, String> {

    List<Produto> findByCategoria(Categoria categoria);
}
