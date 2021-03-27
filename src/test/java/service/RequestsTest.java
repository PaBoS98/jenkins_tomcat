package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import service.Entity.User;
import service.dto.UserDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestsTest {

    Connection connection;
    Requests r;


    @BeforeEach
    void init() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/usersdb?useSSL=false&serverTimezone=UTC", "root", "rootroot");

        r = new Requests(connection);
    }

    @Test
    void createUserTest() throws SQLException {
        User u = new User.Builder().setName("test").setEmail("test").setPassword("test").build();
        Assertions.assertTrue(r.createUser(u));
    }

    @Test
    void findUserTest() throws SQLException {
        User u = new User.Builder().setName("Vasya").setEmail("Pupkin").setPassword("1234").build();
        r.createUser(u);

        UserDto d = r.findUser(u.getName(), u.getPassword());
        ;

        User get = new User.Builder().setName(d.getName()).setEmail(d.getEmail()).setPassword(d.getPassword()).build();

        Assertions.assertEquals(u, get);
    }

    @Test
    void deleteUserTest() throws SQLException {
        User put = new User.Builder().setName("Dmitriy").setEmail("Golybov").setPassword("1234").build();
        r.createUser(put);
        UserDto u = r.findUser("Dmitriy", "1234");
        System.out.println(u.getId());

        Assertions.assertTrue(r.deleteUser((int) u.getId()));
        Assertions.assertNull(r.findUser(u.getName(), u.getPassword()));
    }

    @Test
    void sortedUsersTest() throws SQLException {
        List<UserDto> u = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users order by name");
        while (resultSet.next()) {
            u.add(new UserDto.Builder()
                    .setId(resultSet.getLong("id"))
                    .setName(resultSet.getString("name"))
                    .setEmail(resultSet.getString("email"))
                    .setPassword(resultSet.getString("password")).build());
        }

        List<UserDto> test = r.sortedUsers();

        Assertions.assertEquals(u.size(), test.size());
        if (test.size() == u.size()) {
            for (int i = 0; i < test.size(); i++) {
                Assertions.assertEquals(test.get(i), u.get(i));
            }
        }
    }
}
