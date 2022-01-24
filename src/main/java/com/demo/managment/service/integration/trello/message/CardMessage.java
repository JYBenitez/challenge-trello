package com.demo.managment.service.integration.trello.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CardMessage {
    //private String id;
    @JsonProperty(value = "name")
    private String title;
    @JsonProperty(value = "desc")
    private String description;
    private String idList;
    private List<String> idLabels;
    private List<String> idMembers;

}
