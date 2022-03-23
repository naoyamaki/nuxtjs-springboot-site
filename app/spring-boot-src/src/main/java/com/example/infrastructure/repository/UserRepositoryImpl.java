package com.example.infrastructure.repository;

import com.example.domain.model.UserEntity;
import com.example.domain.repository.UserRepository;
import com.example.infrastructure.jooq.tables.*;
import com.example.infrastructure.jooq.tables.records.UserRecord;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.example.infrastructure.jooq.Tables.USER;

@Repository
public class UserRepositoryImpl implements UserRepository {
    String url = "jdbc:mysql://localhost:3306/main?useUnicode=true&characterEncoding=utf8&connectionTimeZone=SERVER&enabledTLSProtocols=TLSv1.2";
    String userName = "root";
    String password = "#sample1234";
    Connection connection = null;

    {
        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    DSLContext create = DSL.using(connection, SQLDialect.MYSQL);

    public void add(UserEntity user) {
        int numOfInsert = create.insertInto(USER, USER.EMAIL, USER.PASSWORD, USER.USER_NAME, USER.INSERT_DATE, USER.UPDATE_DATE, USER.DELETE_FLAG)
            .values(user.getEmail(), user.getUserName(), user.getUserName(), user.getInsertDate(), user.getUpdateDate(), Byte.valueOf(Boolean.toString(user.getDeleteFlag())))
            .execute();
        if (numOfInsert < 1) {
            // do error action
        }
    }

    public void delete(Integer userId) {
        create.delete(USER)
            .where(USER.ID.equal(userId))
            .execute();
    }

    public UserEntity searchUser(Integer userId) {
        UserRecord record = create
                .selectFrom(USER)
                .where(USER.ID.equal(userId))
                .fetchOneInto(UserRecord.class);
        UserEntity user = new UserEntity(record.getId(), record.getEmail(), record.getUserName(), record.getInsertDate(), record.getUpdateDate(), Boolean.valueOf(Byte.toString(record.getDeleteFlag())));
        return user;
    }
}
