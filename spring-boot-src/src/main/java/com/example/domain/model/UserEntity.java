package com.example.domain.model;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class UserEntity {
    private Integer id;
    private String email;
    private String userName;
    private LocalDateTime insertDate;
    private LocalDateTime updateDate;

    public UserEntity(Integer id, String email, String userName, LocalDateTime insertDate, LocalDateTime updateDate) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.insertDate = insertDate;
        this.updateDate = updateDate;
    }
}