package com.daroz.db.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class AbstractRepository<E> implements Repository<E> {

    private final Connection connection;

    public static Statement st = null;
    public static PreparedStatement pst = null;
    public static ResultSet rs = null;

    public AbstractRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<E> findAll() {
        return null;
    }

    @Override
    public E findById(int value) {
        return null;
    }

    @Override
    public void save(E entity) {

    }

    @Override
    public void update(int id) {

    }

    @Override
    public void deleteById(int value) {

    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}
