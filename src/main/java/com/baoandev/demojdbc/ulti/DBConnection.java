package com.baoandev.demojdbc.ulti;

import java.sql.Connection;

public class DBConnection {
    private final String url = "jdbc:mysql://localhost:3306/demo?createDatabaseIfNotExist=true";
    private final String user = "root";
    private final String password = "12345678";

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = java.sql.DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
