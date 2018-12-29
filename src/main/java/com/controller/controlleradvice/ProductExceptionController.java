package com.controller.controlleradvice;

import com.exception.NotfoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {

    @ExceptionHandler(value = NotfoundException.class)
    public ResponseEntity<String> exception(NotfoundException exception) {
        return new ResponseEntity<>("Happen Not found Exception", HttpStatus.NOT_FOUND);
    }
}
