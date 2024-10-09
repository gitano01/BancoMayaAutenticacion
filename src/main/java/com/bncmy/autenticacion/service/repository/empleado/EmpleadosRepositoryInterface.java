package com.bncmy.autenticacion.service.repository.empleado;

import com.bncmy.autenticacion.model.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface EmpleadosRepositoryInterface  extends JpaRepository<Empleados,Long> {
    @Override
    public Optional<Empleados> findById(Long id);
}
