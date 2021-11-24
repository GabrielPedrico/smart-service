package com.smartservice.adapter.datastore.entity;

import com.smartservice.core.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, UUID> {
}
