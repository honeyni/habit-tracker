package com.example.habittracker.controller;

import com.example.habittracker.dto.response.StatsWeekResponse;
import com.example.habittracker.service.StatsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stats")
public class StatsController {

    private final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("/week")
    public StatsWeekResponse getWeekStats() {
        return statsService.getCurrentWeekStats();
    }
}
