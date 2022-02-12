package com.github.eduumach.hospitalsystem.service.exceptions;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String msg){
        super(msg);
    }
}
