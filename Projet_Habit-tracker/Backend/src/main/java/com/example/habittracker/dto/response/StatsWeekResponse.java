package com.example.habittracker.dto.response;

public record StatsWeekResponse(
        int totalHabits,
        int completedThisWeek,
        double completionRate
) {
}
