package com.example.domain.repository;

import com.example.domain.model.UserEntity;

public interface UserRepository {
    void add(UserEntity user);
    void delete(Integer userId);
    UserEntity searchUser(Integer userId);
}
