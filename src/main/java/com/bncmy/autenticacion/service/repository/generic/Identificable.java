package com.bncmy.autenticacion.service.repository.generic;

import java.io.Serializable;

public interface Identificable<ID extends Serializable> {
    ID getID();
    void setId(ID id);
}
