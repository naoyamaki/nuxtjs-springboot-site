package com.example.usecase;

import com.example.domain.model.PublishReviewEntity;
import com.example.domain.model.UserEntity;
import com.example.domain.repository.PublishReviewRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SearchReviewUseCase {

    @Autowired
    private PublishReviewRepository publishReviewRepository;

    private final Integer REVIEW_PER_PAGE = 20;

    public String getByPage(Integer pageNum) {
        Integer offset = (pageNum - 1) * REVIEW_PER_PAGE;
        ArrayList<PublishReviewEntity> publishReviewList = publishReviewRepository.getByPage(offset, REVIEW_PER_PAGE);

        ObjectMapper objectMapper = new ObjectMapper();
        String response = null;
        try {
            response = objectMapper.writeValueAsString(publishReviewList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return response;
    }

    public String searchByUserId(Integer userId, Integer pageNum) {
        Integer offset = (pageNum - 1) * REVIEW_PER_PAGE;
        ArrayList<PublishReviewEntity> publishReviewList = publishReviewRepository.searchByUserId(userId, offset, REVIEW_PER_PAGE);

        ObjectMapper objectMapper = new ObjectMapper();
        String response = null;
        try {
            response = objectMapper.writeValueAsString(publishReviewList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return response;
    }

    /*
    public String searchByKeyword(String query, Integer pageNum) {
        // 半スペ、全スペ、全スペ（デコード時）の一回以上繰り返しを区切りに配列要素へ分割
        String[] queries = query.split("( |　|%E3%80%80)+");
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
