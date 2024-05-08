package com.tci.javaproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException ex) {
        // Create a custom error response
        ErrorResponse errorResponse = new ErrorResponse("Record Not Found", ex.getMessage());
        // Return ResponseEntity with appropriate status code
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Add more exception handlers as needed

    // Example of handling generic exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex) {
        // Create a custom error response
        ErrorResponse errorResponse = new ErrorResponse("Internal Server Error", ex.getMessage());
        // Return ResponseEntity with appropriate status code
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
