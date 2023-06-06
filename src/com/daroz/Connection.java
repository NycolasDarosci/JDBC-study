package com.daroz;


public class Connection {

    private final DBConnection connection;

    public Connection(DBConnection connection) {
        this.connection = connection;
    }

    public DBConnection getConnection() {
        return connection;
    }
}
