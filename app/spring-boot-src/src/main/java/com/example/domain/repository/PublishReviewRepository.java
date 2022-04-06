package com.example.domain.repository;

import com.example.domain.model.PublishReviewEntity;

import java.util.ArrayList;

public interface PublishReviewRepository {
    ArrayList<PublishReviewEntity> getByPage(Integer offset, Integer limit);
    ArrayList<PublishReviewEntity> searchByUserId(Integer userId, Integer offset, Integer limit);
    // PublishReviewEntity searchByKeyword(String[] query, Integer offset, Integer limit);
}
