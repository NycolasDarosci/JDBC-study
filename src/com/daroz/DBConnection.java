package com.daroz;

public interface DBConnection {

    String url();
    Integer port();

    default void printConnection() {
        System.out.println("url: " + url() + " port: " + port());
    }
}
