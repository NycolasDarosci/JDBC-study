package com.daroz.db.repositories;

import java.util.List;

public interface Repository<E> {

    List<E> findAll();

    E findById(int value);

    void save(E entity);

    void update();

    void delete(int id);

}
