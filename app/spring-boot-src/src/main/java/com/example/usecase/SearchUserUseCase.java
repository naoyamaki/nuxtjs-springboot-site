package com.example.usecase;

import com.example.domain.model.UserEntity;
import com.example.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchUserUseCase {

    @Autowired
    private UserRepository userRepository;

    public String searchUserById(Integer userId) {
        UserEntity user = userRepository.searchUser(userId);
        UserDto userDto = new UserDto(user);
        return userDto.toJson();
    }
}
