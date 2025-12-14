package com.example.SwapShop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // 404 Not Found
public class EliminarNoExistenteException extends RuntimeException {
    public EliminarNoExistenteException(String message) {
        super(message);
    }
}
