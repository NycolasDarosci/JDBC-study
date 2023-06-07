package com.daroz.db.repositories;

import com.daroz.db.exceptions.DBException;
import com.daroz.db.utils.DB;
import com.daroz.entities.Seller;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellerRepository implements Repository<Seller> {

    private final Connection connection;

    public static Statement st = null;
    public static PreparedStatement pst = null;
    public static ResultSet rs = null;

    public SellerRepository(Connection conn) {
        this.connection = conn;
    }

    @Override
    public List<Seller> findAll() {
        List<Seller> entity = new ArrayList<>();
        try {
            st = connection.createStatement();
            rs = st.executeQuery("select * from seller");

            while(rs.next()) {
                entity.add(
                    new Seller(
                        rs.getInt("Id"),
                        rs.getDouble("BaseSalary"),
                        rs.getTimestamp("BirthDate"),
                        rs.getInt("DepartmentId"),
                        rs.getString("Email"),
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
    public void save(Seller entity) {
        try {
            pst = connection.prepareStatement(
            "INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId)" +
                    " VALUES " +
                    "(?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );

            pst.setString(1, entity.getName());
            pst.setString(2, entity.getEmail());
            pst.setDate(3, new java.sql.Date(entity.getBirthDate().getTime()));
            pst.setDouble(4, entity.getBaseSalary());
            pst.setInt(5, entity.getDepartmentId());

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
