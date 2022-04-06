package com.example.infrastructure.repository;

import com.example.domain.model.UserEntity;
import com.example.domain.repository.UserRepository;
import com.example.infrastructure.jooq.tables.*;
import com.example.infrastructure.jooq.tables.records.UserRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static com.example.infrastructure.jooq.Tables.USER;

@Repository
public class UserRepositoryImpl implements UserRepository {

    String url = "jdbc:mysql://db:3306/main?useUnicode=true&characterEncoding=utf8&connectionTimeZone=SERVER&enabledTLSProtocols=TLSv1.2";
    String userName = "root";
    String password = "password1234";

    Connection connection = null;
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    DSLContext create = DSL.using(connection, SQLDialect.MYSQL);

    public void add(UserEntity user) {
        int numOfInsert = create.insertInto(
                USER
                        ,USER.EMAIL
                        ,USER.PASSWORD
                        ,USER.USER_NAME
                        ,USER.INSERT_DATE
                        ,USER.UPDATE_DATE
                        ,USER.DELETE_FLAG
                )
            .values(
                    user.getEmail(),
                    user.getUserName(),
                    user.getUserName(),
                    user.getInsertDate(),
                    user.getUpdateDate(),
                    (byte) 0
            )
            .execute();
        if (numOfInsert != 1) {
            // TODO:エラーを返す
        }
    }

    public void delete(Integer userId) {
        create.delete(USER)
            .where(USER.ID.equal(userId))
            .execute();
    }

    public UserEntity searchUser(Integer userId) {
        Record5<Integer, String, String, LocalDateTime, LocalDateTime> record =
                create.select(
                        USER.ID
                        ,USER.EMAIL
                        ,USER.USER_NAME
                        ,USER.INSERT_DATE
                        ,USER.UPDATE_DATE
                )
                .from(USER)
                .where(USER.ID.equal(userId))
                .fetchOne();
        UserEntity user = null;
        if (record != null) {
            user = new UserEntity(
                    record.getValue(USER.ID),
                    record.getValue(USER.EMAIL),
                    record.getValue(USER.USER_NAME),
                    record.getValue(USER.INSERT_DATE),
                    record.getValue(USER.UPDATE_DATE)
            );
        }
        return user;
    }

    public ArrayList<UserEntity> getAllUsers(Integer offset, Integer limit) {
        Select<Record5<Integer, String, String, LocalDateTime, LocalDateTime>> records =
                create.select(
                        USER.ID
                        ,USER.EMAIL
                        ,USER.USER_NAME
                        ,USER.INSERT_DATE
                        ,USER.UPDATE_DATE
                )
                .from(USER)
                .where(USER.DELETE_FLAG.equal((byte) 0))
                .orderBy(USER.ID).limit(limit).offset(offset);
        if (records.stream().count() == 0) {
            // TODO: エラーを返す
            return null;
        }

        ArrayList<UserEntity> userList = new ArrayList<>();
        for (Record5 record: records) {
            UserEntity user = new UserEntity(
                    record.getValue(USER.ID),
                    record.getValue(USER.EMAIL),
                    record.getValue(USER.USER_NAME),
                    record.getValue(USER.INSERT_DATE),
                    record.getValue(USER.UPDATE_DATE)
            );
            userList.add(user);
        }
        return userList;
    }
}
