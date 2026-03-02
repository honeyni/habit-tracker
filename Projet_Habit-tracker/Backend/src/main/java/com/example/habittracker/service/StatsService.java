package com.example.habittracker.service;

import org.springframework.stereotype.Service;

// Service simple pour les statistiques
@Service
public class StatsService {

    // Exemple: methode placeholder pour un taux de completion
    public double calculateCompletionRate(int done, int total) {
        if (total == 0) {
            return 0.0;
        }
        return (done * 100.0) / total;
    }
}
