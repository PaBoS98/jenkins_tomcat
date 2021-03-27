package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

//    private static String URL = "jdbc:mysql://localhost:3306/userdb?useSSL=false&serverTimezone=UTC";
//    private static String URL = "jdbc:mysql://localhost:3306/usersdb?useSSL=false&serverTimezone=UTC";
    private static String URL = "jdbc:postgresql://192.168.88.105:5432/usersDB";
    private static String USER_NAME = "postgres";
    private static String PASSWORD = "rootroot";

//    public static Connection getConnection(String url, String userName, String password) {
    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^");
            System.out.println("-------------->"+DriverManager.getConnection(URL, USER_NAME, PASSWORD));
                            return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
//            return ConnectionPool.getInstance().getConnection();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
//        return null;
        throw new ArrayIndexOutOfBoundsException();
    }
}