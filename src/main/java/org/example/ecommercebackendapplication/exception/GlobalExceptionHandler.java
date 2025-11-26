package org.example.ecommercebackendapplication.exception;

import jakarta.validation.ConstraintViolationException;
import org.example.ecommercebackendapplication.dto.response.common.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolation(
            DataIntegrityViolationException ex,
            HttpServletRequest request) {

        String message = "Data integrity violation";

        if (ex.getCause() != null && ex.getCause().getMessage().contains("duplicate key")) {
            // Extract the column that caused the duplicate key error
            String causeMessage = ex.getCause().getMessage();
            String column = "field"; // default
            int startIndex = causeMessage.indexOf("(");
            int endIndex = causeMessage.indexOf(")");
            if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
                column = causeMessage.substring(startIndex + 1, endIndex);
            }
            message = "Duplicate value for '" + column + "'";
        }

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                message,
                request.getRequestURI()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            ConstraintViolationException ex,
            HttpServletRequest request) {

        StringBuilder messages = new StringBuilder();
        ex.getConstraintViolations().forEach(v ->
                messages.append(v.getPropertyPath()).append(" ").append(v.getMessage()).append("; ")
        );

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Validation Failed",
                messages.toString(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
