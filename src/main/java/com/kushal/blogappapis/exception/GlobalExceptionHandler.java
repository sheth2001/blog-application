package com.kushal.blogappapis.exception;

import com.kushal.blogappapis.payload.ApiExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiExceptionResponse> resourceNotFoundHandler(ResourceNotFoundException resourceNotFoundException) {
        String message = resourceNotFoundException.getMessage();
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse();
        apiExceptionResponse.setMessage(message);
        apiExceptionResponse.setSuccess(false);

        return new ResponseEntity<ApiExceptionResponse>(apiExceptionResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        Map<String, String> responses = new HashMap<>();

        exception.getBindingResult().getAllErrors().forEach(error -> {
            String field = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            responses.put(field, message);
        });

        return new ResponseEntity<Map<String, String>>(responses, HttpStatus.BAD_REQUEST);
    }
}
