package com.daroz;


import com.daroz.db.utils.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Program {

    public static void main(String[] args) {

        Connection conn;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DB.openConnection();

            st = conn.createStatement();

            rs = st.executeQuery("select * from department");

            while (rs.next()) {
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
