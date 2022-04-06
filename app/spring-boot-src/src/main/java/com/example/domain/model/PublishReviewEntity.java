package com.example.domain.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PublishReviewEntity {
    private Integer id;
    private Integer userId;
    private String title;
    private String body;
    private Integer categoryId;
    private LocalDateTime insertDate;
    private LocalDateTime updateDate;

    public PublishReviewEntity(Integer id, Integer userId, String title, String body, Integer categoryId, LocalDateTime insertDate, LocalDateTime updateDate) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
        this.categoryId = categoryId;
        this.insertDate = insertDate;
        this.updateDate = updateDate;
    }
}