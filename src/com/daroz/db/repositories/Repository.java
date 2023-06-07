package com.daroz.db.repositories;

import java.util.List;

public interface Repository<E> {

    List<E> findAll();

    void save(E entity);

}
