package com.example.dto;

import lombok.Data;

@Data
public class User {

    private long id;
    private String lastName;
    private String firstName;
    private long roleId;
    private long groupId;
}