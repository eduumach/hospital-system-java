package com.github.eduumach.hospitalsystem.controller.exceptions;

import com.github.eduumach.hospitalsystem.service.exceptions.DataConflict;
import com.github.eduumach.hospitalsystem.service.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request){
        StandardError err = new StandardError();
        err.setTitle("Resource not found");
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setDetail(e.getMessage());
        err.setType(request.getRequestURI());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataConflict.class)
    public ResponseEntity<StandardError> cpfAlreadyRegistered(DataConflict e, HttpServletRequest request){
        StandardError err = new StandardError();
        err.setTitle("Data conflict");
        err.setStatus(HttpStatus.CONFLICT.value());
        err.setDetail(e.getMessage());
        err.setType(request.getRequestURI());
        return new ResponseEntity<>(err, HttpStatus.CONFLICT);
    }
}
