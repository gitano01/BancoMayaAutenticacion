package com.bncmy.autenticacion.service.repository.cliente;

import com.bncmy.autenticacion.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientesRepositoryInterface  extends JpaRepository<Clientes,Long> {
     public Optional<Clientes> findById(Long id);
}
