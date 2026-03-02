package com.example.habittracker.service;

import com.example.habittracker.dto.response.StatsWeekResponse;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    public StatsWeekResponse getCurrentWeekStats() {
        return new StatsWeekResponse(0, 0, 0.0);
    }
}
