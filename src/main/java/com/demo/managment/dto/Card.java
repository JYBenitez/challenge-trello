package com.demo.managment.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Card {

    private Integer id;

    private String title;

    private String description;

    private String type;
/*
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "cardid",
            referencedColumnName = "cardid",
            updatable = false,
            insertable = false)
    private List<CardLabelEntity> labels;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "cardid")
    private AssignmentEntity assignment;
*/
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
    private String user;
}
