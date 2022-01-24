package com.demo.managment.service;

import com.demo.managment.model.AssignmentEntity;
import com.demo.managment.model.CardEntity;
import lombok.Data;

@Data
public class CardPersist {
    private CardEntity card;
    private AssignmentEntity assignment;

    public CardPersist(CardEntity val){
    this.card=val;
    }

}
