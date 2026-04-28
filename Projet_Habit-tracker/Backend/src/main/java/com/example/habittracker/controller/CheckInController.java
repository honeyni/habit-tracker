package com.example.habittracker.controller;

import com.example.habittracker.entity.CheckIn;
import com.example.habittracker.repository.CheckInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/check-ins")
public class CheckInController {

    @Autowired
    private CheckInRepository checkInRepository;

    // Créer un check-in
    @PostMapping
    public CheckIn createCheckIn(@RequestBody CheckIn checkIn) {
        return checkInRepository.save(checkIn);
    }

    // Récupérer les check-ins d'une habitude
    @GetMapping
    public List<CheckIn> getCheckInsByHabit(@RequestParam Long habitId) {
        return checkInRepository.findByHabit_Id(habitId);
    }
}
