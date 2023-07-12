package com.daroz.db.repositories;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repository<E> {

    List<E> findAll() throws SQLException;

    E findById(int value) throws SQLException;

    void save(E entity) throws SQLException;

    void update(int id) throws SQLException;

    void deleteById(int value) throws SQLException;

    Connection getConnection();

}
