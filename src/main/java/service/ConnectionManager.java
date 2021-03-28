package service;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {

    private static String URL = "jdbc:postgresql://192.168.88.105:5432/usersDB";
    private static String USER_NAME = "postgres";
    private static String PASSWORD = "rootroot";

    private static BasicDataSource ds = new BasicDataSource();
    private static Connection connection;

    private void instance() throws SQLException {
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl(URL);
        ds.setUsername(USER_NAME);
        ds.setPassword(PASSWORD);
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
        connection = ds.getConnection();
    }

    public Connection getConnection() {
        return connection;
    }
}