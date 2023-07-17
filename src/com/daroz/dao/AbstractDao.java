package com.daroz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AbstractDao {

    public PreparedStatement pst;
    public ResultSet rs;
    public Connection conn;

    public AbstractDao(Connection conn) {
        this.conn = conn;
    }
}
