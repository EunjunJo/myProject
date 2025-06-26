package com.example.demo.global.Exception;

public class DuplicateMemberException extends RuntimeException {
    
    public DuplicateMemberException(String message) {
        super(message);
    }
    
    public DuplicateMemberException(String message, Throwable cause) {
        super(message, cause);
    }
} 