package com.example.habittracker.repository;

import com.example.habittracker.entity.Habit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository pour l'entite Habit
// Integer = type de la cle primaire (id)
@Repository
public interface HabitRepository extends JpaRepository<Habit, Integer> {

    // TODO: Ajouter ici des methodes personnalisées si besoin
    // Exemple:
    // List<Habit> findByName(String name);
}
