package com.daroz.dao;

import java.util.List;

public interface DaoInterface<E> {

    void insert(E entity);

    void update(E entity);

    void deleteById(int id);

    E findById(int id);

    List<E> findAll();
}
