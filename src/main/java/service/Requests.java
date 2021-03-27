package service;

import service.Entity.User;
import service.dto.UserDto;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Requests {

    private Connection connection;
    private PreparedStatement prepareStatement;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Requests(Connection connection) {
        this.connection = connection;
    }

    public boolean createUser(User user) throws SQLException {
        prepareStatement = connection.prepareStatement("insert into users(name, email, password) values (?, ?, ?)");
        prepareStatement.setString(1, user.getName());
        prepareStatement.setString(2, user.getEmail());
        prepareStatement.setString(3, user.getPassword());
        prepareStatement.executeUpdate();
        return true;
    }

    public UserDto findUser(String name, String password) throws SQLException {

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from users");

        while (resultSet.next()) {
            if (name.equals(resultSet.getString("name"))) {
                if (password.equals(resultSet.getString("password"))) {
                    return new UserDto.Builder()
                            .setId(resultSet.getLong("id"))
                            .setName(resultSet.getString("name"))
                            .setEmail(resultSet.getString("email"))
                            .setPassword(resultSet.getString("password")).build();
                }
            }
        }
        return null;
    }

    public boolean deleteUser(int id) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("delete from users where id = " + id);

        return true;
    }

    public List<UserDto> showAllUser() throws SQLException {
        List<UserDto> users = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users");
        while (resultSet.next()) {
            users.add(new UserDto.Builder()
            .setId(resultSet.getLong("id"))
            .setName(resultSet.getString("name"))
            .setEmail(resultSet.getString("email"))
            .setPassword(resultSet.getString("password")).build());
        }

        return users;
    }

    public List<UserDto> sortedUsers() throws SQLException {
        List<UserDto> users = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users order by name");
        while (resultSet.next()) {
            users.add(new UserDto.Builder()
                    .setId(resultSet.getLong("id"))
                    .setName(resultSet.getString("name"))
                    .setEmail(resultSet.getString("email"))
                    .setPassword(resultSet.getString("password")).build());
        }
        return users;
    }
}
