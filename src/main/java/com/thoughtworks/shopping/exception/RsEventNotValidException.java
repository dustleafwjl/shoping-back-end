package com.thoughtworks.shopping.exception;

public class RsEventNotValidException extends RuntimeException{
    private String errorMsg;
    public RsEventNotValidException(String message) {
        this.errorMsg = message;
    }

    @Override
    public String getMessage() {
        return errorMsg;
    }
}
