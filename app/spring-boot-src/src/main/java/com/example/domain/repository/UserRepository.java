package com.example.domain.repository;

import com.example.domain.model.UserEntity;

public interface UserRepository {
    public void add(UserEntity user);
    public void delete(UserEntity user);
    public UserEntity searchUser(Long id);
}
