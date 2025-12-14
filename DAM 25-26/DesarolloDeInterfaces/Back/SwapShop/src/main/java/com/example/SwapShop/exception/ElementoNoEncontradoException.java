package com.example.SwapShop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // 404 Not Found
public class ElementoNoEncontradoException extends RuntimeException {
    public ElementoNoEncontradoException(String message) {
        super(message);
    }
}
