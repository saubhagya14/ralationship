package com.example.demo;

public class CustomErrorHandling extends RuntimeException {

    public CustomErrorHandling(String message) {
        super(message);
    }

}
