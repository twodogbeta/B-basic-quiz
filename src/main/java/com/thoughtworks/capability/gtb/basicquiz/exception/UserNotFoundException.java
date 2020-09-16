package com.thoughtworks.capability.gtb.basicquiz.exception;

// GTB: - 自定异常尽量至少继承自 RuntimeException
public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message){
        super(message);
    }
}
