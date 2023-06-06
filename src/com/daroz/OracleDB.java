package com.daroz;

public class OracleDB implements DBConnection {

    @Override
    public String url() {
        return "http://jdbc";
    }

    @Override
    public Integer port() {
        return 8081;
    }
}
