package com.example.demo.exception;

import com.example.demo.shared.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class AppExceptionHandle {
    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Object> entityNotFoundException(EntityNotFoundException ex){

        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(ex.getMessage())
                .timeStamp(new Date())
                .code(404)
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(value = {EntityAlreadyExistsExeption.class})
    public ResponseEntity<Object> entityNotFoundException(EntityAlreadyExistsExeption ex){

        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(ex.getMessage())
                .timeStamp(new Date())
                .code(409)
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);

    }
}
