package com.daroz.db.repositories;

import com.daroz.db.exceptions.DBException;
import com.daroz.db.utils.DB;
import com.daroz.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository implements Repository<Department> {

    private final Connection connection;

    public static Statement st = null;
    public static PreparedStatement pst = null;
    public static ResultSet rs = null;

    public DepartmentRepository(Connection conn) {
        this.connection = conn;
    }

    @Override
    public List<Department> findAll() {
        List<Department> entity = new ArrayList<>();
        try {
            st = connection.createStatement();
            rs = st.executeQuery("select * from department");

            while (rs.next()) {
                entity.add(
                    new Department(
                        rs.getInt("Id"),
                        rs.getString("Name")
                    )
                );
            }
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
        return entity;
    }

    @Override
    public void save(Department entity) {
        try {
            pst = connection.prepareStatement(
            "INSERT INTO department (Name)" +
                " VALUES " +
                "(?)",
                Statement.RETURN_GENERATED_KEYS
            );

            pst.setString(1, entity.getName());

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet values = pst.getGeneratedKeys();
                while (values.next()) {
                    int id = values.getInt(1);
                    System.out.println("Entity created! Id: " + id);
                }
            } else {
                System.out.println("No rows effected!");
            }
        }
        catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
        finally {
            DB.closeStatement(pst);
        }

    }
}
