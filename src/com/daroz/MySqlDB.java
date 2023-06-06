package com.daroz;

public class MySqlDB implements DBConnection {

    @Override
    public String url() {
        return "http://jdbc";
    }

    @Override
    public Integer port() {
        return 8080;
    }
}
