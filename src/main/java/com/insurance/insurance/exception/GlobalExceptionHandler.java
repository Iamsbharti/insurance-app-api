package com.insurance.insurance.exception;


import com.insurance.insurance.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler{
    @ExceptionHandler(DriverNotFoundException.class)
    public ResponseEntity<?> handleDriverNotFoundException(DriverNotFoundException exception){
        ApiResponse response = new ApiResponse();
        response.setStatus("error");
        response.setMessage(exception.getMessage());
        response.setData(null);
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }
}
