package com.demo.managment.mapper;

import com.demo.managment.dto.Card;
import com.demo.managment.model.CardEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

@Slf4j
public class CardMap {
    private static CardMap instance;
    private CardMap(){}

    public static CardMap getInstance(){
        if (null == instance) {
            instance = new CardMap();
        }
        return instance;
    }
    public  Card map(CardEntity source){
        Card target = new Card();
        BeanUtils.copyProperties(source,target);
        target.setType(source.getType().getVal());
        return target;
    }
    public  CardEntity map(Card source){
        CardEntity target = new CardEntity();
        BeanUtils.copyProperties(source,target);
        target.setType(CardEntity.Type.valueOf(source.getType()));
        return target;
    }

    public  CardEntity map(CardEntity target, Card source){
        BeanUtils.copyProperties(source,target);
        return target;
    }

}
