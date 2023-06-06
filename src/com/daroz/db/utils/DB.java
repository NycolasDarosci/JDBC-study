package com.daroz.db.utils;

import com.daroz.db.exceptions.DBException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    private static Properties loadProperties() {
        try (FileInputStream str = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(str);
            return props;
        }
        catch (IOException e) {
            throw new DBException(e.getMessage(), e.getCause());
        }
    }

    public static Connection openConnection() {
        if (conn == null) {
            try {
                Properties props = loadProperties();
                conn = DriverManager.getConnection(props.getProperty("dburl"), props);
            } catch (SQLException e) {
                throw new DBException(e.getMessage(), e.getCause());
            }

        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DBException(e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e){
                throw new DBException(e.getMessage(), e.getCause());
            }
        }

    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e){
                throw new DBException(e.getMessage(), e.getCause());
            }
        }
    }

}
