package com.smartservice.adapter.datastore.repositories;

import com.smartservice.adapter.datastore.entities.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Integer> {

    Optional<Mesa> findByQrCode(String qrCode);
}
