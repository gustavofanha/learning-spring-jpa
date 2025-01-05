package com.fanhagustavo.learning.resources.exceptions;

import com.fanhagustavo.learning.services.exceptions.DatabaseException;
import com.fanhagustavo.learning.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String rsError = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError error = new StandardError(Instant.now(), status.value(), rsError, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
        String rsError = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;

        StandardError error = new StandardError(Instant.now(), status.value(), rsError, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
}
