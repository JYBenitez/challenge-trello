package com.demo.managment.service;

import com.demo.managment.dto.Card;
import com.demo.managment.exception.CardServiceException;
import com.demo.managment.exception.CardTypeException;
import com.demo.managment.mapper.CardMap;
import com.demo.managment.model.CardEntity;
import com.demo.managment.repository.AssignmentRepository;
import com.demo.managment.repository.CardRepository;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor()
@Service
public class CardService {
    @Autowired
    private final CardRepository repository;

    @Autowired
    private final AssignmentRepository assignmentRepository;
    @Autowired
    private final PrepareCardHelper prepareCardHelper;

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

    public Card findById(@NotNull final Integer id){
        var card = repository.findById(id);
        Card result;
        if (card.isPresent()){
            result = CardMap.getInstance().map(card.get());
            return result;
        }
        else
        {
            throw new CardServiceException("Card not exists cardid: " + id);
        }
    }

    public Card save(@NotNull final Card source){

        try {
            var input = CardMap.getInstance().map(source);
            var persisted = persiste(preparer(input) );
            return CardMap.getInstance().map(persisted);
        }
        catch (Exception e){
           throw new CardServiceException("Couldn't save card");
        }
    }

    private CardPersist preparer(CardEntity card){
        if (null == card.getType()){
            throw new CardTypeException("Card type can not null");
        }

        if (CardEntity.Type.BUG.equals(card.getType())){
           return prepareCardHelper.prepareBug(card);
        }
        if (CardEntity.Type.TASK.equals(card.getType())){
            return prepareCardHelper.prepareTask(card);
        }
        else {
           return prepareCardHelper.prepareIssue(card);
        }
    }

    private CardEntity persiste(CardPersist cardPersist){
        repository.save(cardPersist.getCard());
        if (null != assignmentRepository){
            assignmentRepository.save(cardPersist.getAssignment());
        }
        return cardPersist.getCard();
    }

    private void sendToTrello(CardPersist cardPersist){

    }

    public Card update(@NotNull final Card source) {
            var current = repository.findById(source.getId());
           return  current.map((card) -> {
                var persisted = repository.save(CardMap.getInstance().map(card,source));
               return   CardMap.getInstance().map(persisted);
            }).orElseThrow(()-> new CardServiceException(""));
    }
}
