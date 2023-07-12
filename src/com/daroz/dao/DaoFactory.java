package com.daroz.dao;

import com.daroz.dao.impl.DepartmentDaoJDBC;
import com.daroz.dao.impl.SellerDaoJDBC;
import com.daroz.entities.Department;
import com.daroz.entities.Seller;

public class DaoFactory {

    public static DaoInterface<Seller> createSellerDao() {
        return new SellerDaoJDBC();
    }

    public static DaoInterface<Department> createDepartmentDao() {
        return new DepartmentDaoJDBC();
    }

}
