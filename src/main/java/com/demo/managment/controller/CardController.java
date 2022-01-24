package com.demo.managment.controller;

import com.demo.managment.dto.Card;
import com.demo.managment.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor()
@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private final CardService service;

    @GetMapping("/")
    public List<Card> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Card findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @PostMapping("/")
    public Card save( @RequestBody Card card){

        return service.save(card);
    }
}
