package com.example.usecase;

import com.example.domain.model.UserEntity;

import java.time.LocalDateTime;

public class UserDto {
    private Integer id;
    private String email;
    private String userName;
    private Boolean deleteFlag;

    public UserDto(UserEntity user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.userName = user.getUserName();
        this.deleteFlag = user.getDeleteFlag();
    }

    public String toJson() {
        return "{\"id\":" +this.id+ ",\"email\":\"" +this.email+ "\",\"name\":\"" +this.userName+ "\",\"isActive\":" +this.deleteFlag+"}";
    }
}
