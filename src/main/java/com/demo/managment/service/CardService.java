package com.demo.managment.service;

import com.demo.managment.dto.Card;
import com.demo.managment.mapper.CardMap;
import com.demo.managment.model.CardEntity;
import com.demo.managment.repository.CardRepository;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor()
@Service
public class CardService {
    @Autowired
    private final CardRepository repository;

    public List<Card> findAll(){
        List<Card> result = new ArrayList<>();
        var list = repository.findAll();
        if (null != list){
            list.forEach(c -> {
                Card card = CardMap.getInstance().map(c);
                result.add(card);
            });
        }

        return result;
    }

    public Optional<Card> findById(@NotNull final Integer id){
        var card = repository.findById(id);
        Card result;
        if (card.isPresent()){
            result = CardMap.getInstance().map(card.get());
            return Optional.of(result);
        }
        else
        {
            return Optional.empty();
        }
    }

    public Optional<Card> persist(@NotNull final Card source){

        try {
            var persisted = repository.save(CardMap.getInstance().map(source));
            return Optional.of(CardMap.getInstance().map(persisted));
        }
        catch (Exception e){
            //ToDo: Log
           return  Optional.empty();
        }
    }
}
