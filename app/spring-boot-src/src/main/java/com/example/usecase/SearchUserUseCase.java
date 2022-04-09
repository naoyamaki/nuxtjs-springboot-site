package com.example.usecase;

import com.example.domain.model.UserEntity;
import com.example.domain.repository.UserRepository;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

@Service
public class SearchUserUseCase {
    Logger logger = LoggerFactory.getLogger(SearchUserUseCase.class);

    @Autowired
    private UserRepository userRepository;

    private final Integer REVIEW_PER_PAGE = 20;

    public String searchUserById(Integer userId) {
        UserEntity user = userRepository.searchUser(userId);

        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        String response = null;
        try {
            response = objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        logger.info(response);
        return response;
    }

    public String getAllUsers(Integer pageNum) {
        Integer offset = (pageNum - 1) * REVIEW_PER_PAGE;
        ArrayList<UserEntity> userList = userRepository.getAllUsers(offset, REVIEW_PER_PAGE);

        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        String response = null;
        try {
            response = objectMapper.writeValueAsString(userList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        logger.info(response);
        return response;
    }
}
