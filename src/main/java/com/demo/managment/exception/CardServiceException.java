package com.demo.managment.exception;

import com.sun.istack.NotNull;

public class CardServiceException extends RuntimeException {

    public CardServiceException(@NotNull final String message){
        super(message);
    }
}
