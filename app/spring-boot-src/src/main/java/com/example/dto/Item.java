package com.example.dto;

import lombok.Data;

@Data
public class Item {

    private long id;
    private String name;
    private long category;
    private long[] tag;
}