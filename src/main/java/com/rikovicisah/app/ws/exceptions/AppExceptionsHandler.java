package com.rikovicisah.app.ws.exceptions;

import com.rikovicisah.app.ws.ui.model.response.ErrorMessageModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class AppExceptionsHandler  {

    @ExceptionHandler(value = {UserServiceException.class})
    public ResponseEntity<Object> handleUserServiceException(UserServiceException e, WebRequest request){
        ErrorMessageModel messageModel = new ErrorMessageModel(new Date(), e.getMessage());
        return new ResponseEntity<>(messageModel, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException(Exception e, WebRequest request){
        ErrorMessageModel messageModel = new ErrorMessageModel(new Date(), e.getMessage());
        return new ResponseEntity<>(messageModel, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
