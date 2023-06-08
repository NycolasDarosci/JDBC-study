package com.daroz;

import com.daroz.db.repositories.DepartmentRepository;
import com.daroz.db.repositories.Repository;
import com.daroz.db.repositories.SellerRepository;
import com.daroz.db.utils.DB;
import com.daroz.entities.Department;
import com.daroz.entities.Seller;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        Connection conn = DB.openConnection();

        Repository<Department> departmentRepository = new DepartmentRepository(conn);
        Repository<Seller> sellerRepository = new SellerRepository(conn);

        // findAll
//        List<Department> departments = departmentRepository.findAll();
//        System.out.println(departments);
//
//        List<Seller> sellers = sellerRepository.findAll();
//        System.out.println(sellers);

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
    }
}
