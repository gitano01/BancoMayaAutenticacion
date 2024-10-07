package com.bncmy.autenticacion.service.repository.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface GenericRepository<T extends Identificable<ID>, ID extends Serializable> extends JpaRepository<T,ID> {

    public Optional<T> findById(ID id);

}
