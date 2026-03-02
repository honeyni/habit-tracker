package com.example.habittracker.exception;

// Erreur quand une ressource n'existe pas
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
