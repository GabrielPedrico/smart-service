package com.smartservice.adapter.datastore.repositories;

import com.smartservice.core.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, UUID> {

    Optional<Usuario> findByEmail(String email);

    Boolean existsByEmailAndPassword(String email,String password);
}
