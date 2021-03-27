package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

//    private static String URL = "jdbc:mysql://localhost:3306/userdb?useSSL=false&serverTimezone=UTC";
//    private static String URL = "jdbc:mysql://localhost:3306/usersdb?useSSL=false&serverTimezone=UTC";
    private static String URL = "jdbc:mysql://192.168.88.105:3306/userdb";
    private static String USER_NAME = "root";
    private static String PASSWORD = "rootroot";

//    public static Connection getConnection(String url, String userName, String password) {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
                            return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
//            return ConnectionPool.getInstance().getConnection();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
//        return null;
        System.out.println();
        throw new ArrayIndexOutOfBoundsException();
    }
}