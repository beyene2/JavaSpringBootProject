package com.beyene.springPracticeProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeNotFoundExceptionController {
    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<Object>exception(EmployeeNotFoundException exception){
        return new ResponseEntity<>("Employee Not Found", HttpStatus.NOT_FOUND);
    }
}
