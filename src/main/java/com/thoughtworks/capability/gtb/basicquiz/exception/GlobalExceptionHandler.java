package com.thoughtworks.capability.gtb.basicquiz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Error> userNotFound(Exception ex) {
        Error error = Error.builder()
                .time(LocalDateTime.now().toString())
                .status(HttpStatus.NOT_FOUND.value())
                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(ex.getMessage()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity invalidParameter(Exception ex) {
        String er =  ((MethodArgumentNotValidException) ex).getBindingResult().getAllErrors().get(0).getDefaultMessage();
        Error error = Error.builder()
                .time(LocalDateTime.now().toString())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(er).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }
}
