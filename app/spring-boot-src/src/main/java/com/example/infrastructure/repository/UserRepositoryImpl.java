package com.example.infrastructure.repository;

import com.example.domain.model.UserEntity;
import com.example.domain.repository.UserRepository;
import com.example.infrastructure.jooq.tables.*;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class UserRepositoryImpl implements UserRepository {
    @Value("${spring.datasource.url}")
    String userName;
    @Value("${spring.datasource.username}")
    String password;
    @Value("${spring.datasource.password}")
    String url;
    Connection conn;
    {
        try {
            conn = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

    public void add(UserEntity user) {

    }

    public void delete(UserEntity user) {

    }

    public UserEntity searchUser(Long id) {
        UserEntity user = new UserEntity("tanaka","hajime", 7L);
        return user;
    }
}
