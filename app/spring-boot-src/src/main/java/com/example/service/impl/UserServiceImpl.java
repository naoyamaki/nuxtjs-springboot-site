package com.example.service.impl;

import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.dto.User;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User serchUserById(long id) throws SQLException {
        User user = new User();
        user.setId(id);
        user.setLastName("テスト");
        user.setFirstName("太郎");
        user.setRoleId(2);
        user.setGroupId(5);
        return user;
    };

    @Override
    public List<User> getAllUser() throws SQLException {
        List<User> userList = new ArrayList<User>();
        User user1 = new User();
        user1.setId(1);
        user1.setLastName("テスト");
        user1.setFirstName("太郎");
        user1.setRoleId(2);
        user1.setGroupId(3);
        userList.add(user1);

        User user2 = new User();
        user2.setId(2);
        user2.setLastName("テスト");
        user2.setFirstName("太郎");
        user2.setRoleId(2);
        user2.setGroupId(5);
        userList.add(user2);

        User user3 = new User();
        user3.setId(3);
        user3.setLastName("テスト");
        user3.setFirstName("太郎");
        user3.setRoleId(4);
        user3.setGroupId(3);
        userList.add(user3);

        return userList;
    };

    @Override
    public String formattingJson(User[] userList) {
        return "OK";
    };
}