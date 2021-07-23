package com.example.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import com.example.dto.User;

@Service
public interface UserService {

    public User serchUserById(long id) throws SQLException;
    public List<User> getAllUser() throws SQLException;
    public String formattingJson(User[] userList);
}