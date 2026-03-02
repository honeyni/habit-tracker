package com.example.habittracker.controller;

import com.example.habittracker.model.CheckIn;
import com.example.habittracker.repository.CheckInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/check-ins")
public class CheckInController {

    @Autowired
    private CheckInRepository checkInRepository;

    // Créer un nouveau check-in
    @PostMapping
    public CheckIn createCheckIn(@RequestBody CheckIn checkIn) {
        return checkInRepository.save(checkIn);
    }

    // Récupérer tous les check-ins pour une habitude spécifique
    @GetMapping
    public List<CheckIn> getCheckInsByHabit(@RequestParam Long habitId) {
        return checkInRepository.findByHabitId(habitId);
    }
}
