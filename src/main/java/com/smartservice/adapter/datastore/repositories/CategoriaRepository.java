package com.smartservice.adapter.datastore.repositories;

import com.smartservice.adapter.datastore.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, String> {

    Optional<Categoria> findByNome(String categoria);
}
