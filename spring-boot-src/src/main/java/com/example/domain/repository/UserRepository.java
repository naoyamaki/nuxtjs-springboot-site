package com.example.domain.repository;

import com.example.domain.model.UserEntity;

import java.util.ArrayList;

public interface UserRepository {
    void add(UserEntity user);
    void delete(Integer userId);
    UserEntity searchUser(Integer userId);
    ArrayList<UserEntity> getAllUsers(Integer offset, Integer limit);
}
