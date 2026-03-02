package com.example.habittracker.exception;

// Erreur quand la requete est invalide
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
