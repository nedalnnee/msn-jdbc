package com.msnit.msn_dbl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection implements Database {


    public static final String JDBC_DATABASE_URL = "JDBC_DATABASE_URL";
    public static boolean databaseConnected = false;
    public static boolean online = false;
    private Connection connection;

    public PostgresConnection(boolean connectNow) {
    }


    private boolean connectOnline() throws SQLException {
        String url = System.getenv(JDBC_DATABASE_URL);

        if (url != null) {
            connection = DriverManager.getConnection(url);
            return true;
        }
        return false;
    }

    @Override
    public Connection getConnection() {
        return this.connection;
    }


    @Override
    public boolean connect(String username, String password, String url) {
        try {
            online = connectOnline();
            if (!connectOnline())
                this.connection = DriverManager.getConnection(url, username, password);
            databaseConnected = true;
        } catch (SQLException e) {
            databaseConnected = false;

        }
        return databaseConnected;
    }

    @Override
    public boolean connect(String url) {
        try {

            if (url != null) {
                connection = DriverManager.getConnection(url);
                return true;
            }
        } catch (SQLException e) {

        }
        return false;
    }
}