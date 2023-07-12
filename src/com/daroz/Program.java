package com.daroz;

import com.daroz.db.exceptions.DBException;
import com.daroz.db.repositories.DepartmentRepository;
import com.daroz.db.repositories.Repository;
import com.daroz.db.repositories.SellerRepository;
import com.daroz.db.utils.DB;
import com.daroz.entities.Department;
import com.daroz.entities.Seller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Program {

    public static Connection conn = DB.openConnection();

    public static Repository<Department> departmentRepository = new DepartmentRepository(conn);
    public static Repository<Seller> sellerRepository = new SellerRepository(conn);

    public static Statement st = null;

    public static void main(String[] args) {
        try {
            commitAndRollback();

            // findAll
        List departments = departmentRepository.findAll();
        System.out.println(departments);

        List sellers = sellerRepository.findAll();
        System.out.println(sellers);

            // create
//        Department d = new Department("HR");
//
//        Seller s = new Seller(
//            2000.0,
//            new Date(System.currentTimeMillis()),
//            1,
//            "carlos@gmail",
//            "Carlos"
//        );
//
//        departmentRepository.save(d);
//        sellerRepository.save(s);

            // delete

//        departmentRepository.delete(7);
//        sellerRepository.delete(8);

            // findById

//        Department d = departmentRepository.findById(1);
//        Seller s = sellerRepository.findById(1);

            DB.closeConnection();
        } catch (SQLException e) {
            try {
                conn.rollback();
                throw new DBException("Rollback occurred successfully!" + e.getMessage());
            } catch (SQLException e2) {
                throw new DBException("Error on rollback!" + e2.getMessage());
            }
        }
    }

    static void commitAndRollback() {
        try {

            // do not confirm automatically transaction
            // all transactions will be waiting for an explicity confirm
            sellerRepository.getConnection().setAutoCommit(false);

            int rows = st.executeUpdate("UPDATE seller SET BaseSalary = 200 WHERE DepartmentId = 1");

            int x = 0;
            if (x < 1) {
                throw new DBException("Simulation error");
            }

            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 200 WHERE DepartmentId = 2");

            // confirm transaction
            sellerRepository.getConnection().commit();

            System.out.println("rows affected: " + rows);
            System.out.println("rows affected: " + rows2);

        } catch (SQLException e) {
            try {
                conn.rollback();
                throw new DBException("Rollback successfully: " + e.getMessage());
            } catch (SQLException e2) {
                throw new DBException("Rollback failed: " + e2.getMessage());
            }
        }

    }

}
