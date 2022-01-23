package com.demo.managment.controller;

import com.demo.managment.exception.CardServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(CardServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String cardExceptionHandler(CardServiceException e){
        return e.getMessage();
    }
}
