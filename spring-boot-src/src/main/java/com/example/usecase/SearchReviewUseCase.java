package com.example.usecase;

import com.example.domain.model.PublishReviewEntity;
import com.example.domain.model.UserEntity;
import com.example.domain.repository.PublishReviewRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SearchReviewUseCase {
    Logger logger = LoggerFactory.getLogger(SearchReviewUseCase.class);

    @Autowired
    private PublishReviewRepository publishReviewRepository;

    private final Integer REVIEW_PER_PAGE = 20;

    public String getByPage(Integer pageNum) {
        Integer offset = (pageNum - 1) * REVIEW_PER_PAGE;
        ArrayList<PublishReviewEntity> publishReviewList = publishReviewRepository.getByPage(offset, REVIEW_PER_PAGE);

        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        String response = null;
        try {
            response = objectMapper.writeValueAsString(publishReviewList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        logger.info(response);
        return response;
    }

    public String searchByUserId(Integer userId, Integer pageNum) {
        Integer offset = (pageNum - 1) * REVIEW_PER_PAGE;
        ArrayList<PublishReviewEntity> publishReviewList = publishReviewRepository.searchByUserId(userId, offset, REVIEW_PER_PAGE);

        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        String response = null;
        try {
            response = objectMapper.writeValueAsString(publishReviewList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        logger.info(response);
        return response;
    }

    /*
    public String searchByKeyword(String query, Integer pageNum) {
        // ?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        String[] queries = query.split("( |???|%E3%80%80)+");
        PublishReviewEntity publishReviewEntity = publishReviewRepository.searchByKeyword(queries, offset, REVIEW_PER_PAGE);

        ObjectMapper objectMapper = new ObjectMapper();
        String response = null;
        try {
            response = objectMapper.writeValueAsString(x);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return response;
    }
     */
}
