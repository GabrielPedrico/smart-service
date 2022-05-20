package com.smartservice.adapter.datastore.repositories;

import com.smartservice.adapter.datastore.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, String> {

    Optional<Usuario> findByEmail(String email);
}
