import service.ConnectionManager;
import service.Entity.User;
import service.ReadFromProperties;
import service.Requests;
import service.dto.UserDto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {

        Map<String, String> m = new HashMap<>();

        System.out.println(m.size());

//        new ReadFromProperties();

//        Connection connection = ConnectionManager.getConnection();
//
//        Requests r = new Requests(connection);
//
////        User u = new User.Builder().setName("sagwqgqw").setEmail("sagaw@gmaaw").setPassword("123445").build();
////
////        r.createUser(u);
//
//        List<UserDto> u = r.showAllUser();
//
//        System.out.println(u);

//        <%
//        List<UserDto> userList = (List<UserDto>) request.getAttribute("users");
//        for(UserDto u : userList){
//                %>
//                <tr>
//                    <td><%= u.getId()%></td>
//                    <td><%= u.getName()%></td>
//                    <td><%= u.getEmail()%></td>
//                    <td><%= u.getPassword()%></td>
//                </tr>
//                <%
//        }
//                %>

//        <c:if active="true">
//                I see!  You  have a name.. well.. Hello
//                </c:if>
//            <c:if active="false">
//                I see!  You don't have a name.. well.. Hello no name
//                </c:if>

//        <form method="post" class="w3-container w3-center w3-padding-64">
//                                                <label>Password:
//                                                    <input class="w3-input" type="password" name="pass"><br />
//                                                </label>
//                                                <div class="w3-container w3-center">
//                                                    <button style="border:8px solid white"
//        class="w3-xlarge w3-white w3-round-large w3-hover-shadow w3-hover-border-green"
//        type="submit">Submit</button>
//                                                </div>
//                                            </form>
    }
}
