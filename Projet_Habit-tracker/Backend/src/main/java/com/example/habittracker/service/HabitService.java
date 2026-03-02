package com.example.habittracker.service;

import com.example.habittracker.entity.Habit;
import com.example.habittracker.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Service = logique metier pour les habitudes
@Service
public class HabitService {

    private final HabitRepository habitRepository;

    // Injection du repository par constructeur
    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    // Recuperer toutes les habitudes
    public List<Habit> getAllHabits() {
        return habitRepository.findAll();
    }

    // Recuperer une habitude par son id
    public Optional<Habit> getHabitById(int id) {
        return habitRepository.findById(id);
    }

    // Creer une nouvelle habitude
    public Habit createHabit(Habit habit) {
        return habitRepository.save(habit);
    }

    // Mettre a jour une habitude existante
    public Habit updateHabit(int id, Habit newData) {
        Optional<Habit> existingHabit = habitRepository.findById(id);

        if (existingHabit.isPresent()) {
            Habit habit = existingHabit.get();
            habit.setName(newData.getName());
            habit.setTarget(newData.getTarget());
            return habitRepository.save(habit);
        }

        return null; // simple pour niveau scolaire
    }

    // Supprimer une habitude
    public boolean deleteHabit(int id) {
        if (habitRepository.existsById(id)) {
            habitRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
