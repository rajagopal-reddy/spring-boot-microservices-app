package com.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        String message = ex.getMessage();
        ApiResponse apiResponse = ApiResponse
        		.builder()
                .message(message)
                .success(false) // Assuming this should be false for an exception case
                .status(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
}
