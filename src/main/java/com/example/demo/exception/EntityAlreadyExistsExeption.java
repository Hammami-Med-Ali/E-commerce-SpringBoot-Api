package com.example.demo.exception;

public class EntityAlreadyExistsExeption extends RuntimeException {
    public EntityAlreadyExistsExeption() {
    }

    public EntityAlreadyExistsExeption(String message) {
        super(message);
    }
}
