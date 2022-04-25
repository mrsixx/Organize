package com.es.agriculturafamiliar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.es.agriculturafamiliar.entity.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    Optional<Administrador> findAdministradorByUserId(Long id);
}
