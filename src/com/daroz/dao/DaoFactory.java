package com.daroz.dao;

import com.daroz.dao.impl.DepartmentDaoJDBC;
import com.daroz.dao.impl.SellerDaoJDBC;
import com.daroz.entities.Department;
import com.daroz.entities.Seller;

import java.sql.Connection;

public class DaoFactory {

    public static DaoInterface<Seller> createSellerDao(Connection conn) {
        return new SellerDaoJDBC(conn);
    }

    public static DaoInterface<Department> createDepartmentDao(Connection conn) {
        return new DepartmentDaoJDBC(conn);
    }

}
