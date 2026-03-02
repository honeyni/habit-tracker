package com.example.habittracker.controller;

import com.example.habittracker.model.Habit;
import com.example.habittracker.repository.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/habits")
public class HabitController {

    @Autowired
    private HabitRepository habitRepository;

    // Récupérer toutes les habitudes
    @GetMapping
    public List<Habit> getAllHabits() {
        return habitRepository.findAll();
    }

    // Récupérer une habitude par ID
    @GetMapping("/{id}")
    public Optional<Habit> getHabitById(@PathVariable Long id) {
        return habitRepository.findById(id);
    }

    // Créer une nouvelle habitude
    @PostMapping
    public Habit createHabit(@RequestBody Habit habit) {
        return habitRepository.save(habit);
    }

    // Mettre à jour une habitude existante
    @PutMapping("/{id}")
    public Habit updateHabit(@PathVariable Long id, @RequestBody Habit habitDetails) {
        Habit habit = habitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habitude non trouvée avec id " + id));
        habit.setName(habitDetails.getName());
        habit.setDescription(habitDetails.getDescription());
        habit.setType(habitDetails.getType());
        return habitRepository.save(habit);
    }

    // Supprimer une habitude
    @DeleteMapping("/{id}")
    public void deleteHabit(@PathVariable Long id) {
        habitRepository.deleteById(id);
    }
}
