package com.rikovicisah.app.ws.exceptions;

public class UserServiceException extends RuntimeException {
    public UserServiceException(){}

    public UserServiceException(String message){
        super(message);
    }

}
