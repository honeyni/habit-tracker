package com.example.habittracker.repository;

import com.example.habittracker.entity.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Repository pour l'entite CheckIn
@Repository
public interface CheckInRepository extends JpaRepository<CheckIn, Integer> {

    // Methode personnalisée: recuperer les check-ins d'une habitude
    List<CheckIn> findByHabitId(int habitId);
}
