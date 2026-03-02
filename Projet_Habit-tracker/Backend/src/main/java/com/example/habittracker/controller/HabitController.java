package com.example.habittracker.controller;

import com.example.habittracker.dto.request.HabitCreateRequest;
import com.example.habittracker.dto.response.HabitResponse;
import com.example.habittracker.service.HabitService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habits")
public class HabitController {

    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @GetMapping
    public List<HabitResponse> getAllHabits() {
        return habitService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HabitResponse createHabit(@RequestBody HabitCreateRequest request) {
        return habitService.create(request);
    }
}
