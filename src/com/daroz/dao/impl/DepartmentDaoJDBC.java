package com.daroz.dao.impl;

import com.daroz.dao.AbstractDao;
import com.daroz.dao.DaoInterface;
import com.daroz.entities.Department;

import java.sql.Connection;
import java.util.List;

public class DepartmentDaoJDBC extends AbstractDao implements DaoInterface<Department> {

    public DepartmentDaoJDBC(Connection conn) { super(conn); }

    @Override
    public void insert(Department entity) {

    }

    @Override
    public void update(Department entity) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Department findById(int id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return null;
    }
}
