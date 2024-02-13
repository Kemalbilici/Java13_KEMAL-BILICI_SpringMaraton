package com.kemal.exception;

import lombok.Getter;

@Getter
public class RandevuException extends RuntimeException{

    private final ErrorType errorType;

    public RandevuException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }
    public RandevuException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }


    public RandevuException(String s, ErrorType errorType) {
        this.errorType = errorType;
    }
}