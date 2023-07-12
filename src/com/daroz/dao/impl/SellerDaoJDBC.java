package com.daroz.dao.impl;

import com.daroz.dao.DaoInterface;
import com.daroz.db.exceptions.DBException;
import com.daroz.db.utils.DB;
import com.daroz.entities.Department;
import com.daroz.entities.Seller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SellerDaoJDBC extends AbstractDao implements DaoInterface<Seller> {

    private static String FIND_BY_ID =
        "SELECT s.*, d.Name as DepName " +
        "FROM seller s JOIN department d " +
        "ON s.departmentId = d.Id " +
        "WHERE s.Id = ?";

    public SellerDaoJDBC(Connection conn) { super(conn); }

    @Override
    public void insert(Seller entity) {

    }

    @Override
    public void update(Seller entity) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Seller findById(int id) {
        try {
            pst = conn.prepareStatement(FIND_BY_ID);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next()) {
                Seller seller = new Seller();
                Department department = new Department();

                department.setId(rs.getInt("DepartmentId"));
                department.setName(rs.getString("DepName"));

                seller.setId(rs.getInt("Id"));
                seller.setName(rs.getString("Name"));
                seller.setEmail(rs.getString("Email"));
                seller.setBirthDate(rs.getDate("BirthDate"));
                seller.setBaseSalary(rs.getDouble("BaseSalary"));
                seller.setDepartment(department);
                return seller;
            }

        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            DB.closeStatement(pst);
            DB.closeResultSet(rs);
        }
        return null;
    }


    @Override
    public List<Seller> findAll() {
        return null;
    }
}