package com.example.domain.model;

import lombok.Getter;

@Getter
public class UserEntity {
    private Long id;
    private String firstName;
    private String lastName;
    private Long rollId;
    private Integer status;

    public UserEntity(String firstName, String lastName, Long rollId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rollId = rollId;
    }
}
