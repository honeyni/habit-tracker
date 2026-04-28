package com.example.habittracker.service;

import com.example.habittracker.entity.Habit;
import com.example.habittracker.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitService {

    private final HabitRepository habitRepository;

    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public List<Habit> getAllHabits() {
        return habitRepository.findAll();
    }

    public Optional<Habit> getHabitById(Long id) {
        return habitRepository.findById(id);
    }

    public Habit createHabit(Habit habit) {
        return habitRepository.save(habit);
    }

    public Habit updateHabit(Long id, Habit newData) {
        Optional<Habit> existingHabit = habitRepository.findById(id);

        if (existingHabit.isPresent()) {
            Habit habit = existingHabit.get();
            habit.setName(newData.getName());
            habit.setTarget(newData.getTarget());
            return habitRepository.save(habit);
        }

        return null;
    }

    public boolean deleteHabit(Long id) {
        if (habitRepository.existsById(id)) {
            habitRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
