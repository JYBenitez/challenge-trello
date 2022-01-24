package com.demo.managment.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Card {

    private Integer id;

    private String title;

    private String description;

    private String type;

    private String label;

    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
    private String user;
}
