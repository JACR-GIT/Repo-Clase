package com.example.SwapShop.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        Map<String, String> error = new HashMap<>();
        Throwable cause = ex.getCause();

        if (cause instanceof InvalidFormatException && ((InvalidFormatException) cause).getTargetType().isEnum()) {
            InvalidFormatException ife = (InvalidFormatException) cause;
            String fieldName = ife.getPath().stream()
                                  .map(ref -> ref.getFieldName())
                                  .collect(Collectors.joining("."));
            String invalidValue = ife.getValue().toString();
            String acceptedValues = Arrays.stream(ife.getTargetType().getEnumConstants())
                                          .map(Object::toString)
                                          .collect(Collectors.joining(", "));
            
            error.put("campo", fieldName);
            error.put("error", String.format("Valor inválido '%s'. Los valores aceptados son: [%s]", invalidValue, acceptedValues));
            
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

        error.put("error", "La petición no tiene un formato JSON válido.");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
