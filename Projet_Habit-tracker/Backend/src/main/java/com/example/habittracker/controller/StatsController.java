package com.example.habittracker.controller;

import com.example.habittracker.entity.CheckIn;
import com.example.habittracker.repository.CheckInRepository;
import com.example.habittracker.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/stats")
public class StatsController {

    @Autowired
    private CheckInRepository checkInRepository;

    //Retourne tous les check-ins de la semaine pour une habitude donnée.

    @GetMapping("/week")
    public List<CheckIn> getWeeklyStats(@RequestParam Long habitId) {
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = DateUtils.startOfWeek(today);
        LocalDate endOfWeek = DateUtils.endOfWeek(today);
        return checkInRepository.findByHabitIdAndDateBetween(habitId, startOfWeek, endOfWeek);
    }
}
