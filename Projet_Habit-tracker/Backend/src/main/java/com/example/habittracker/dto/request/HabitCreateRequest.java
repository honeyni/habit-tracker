package com.example.habittracker.dto.request;

import com.example.habittracker.util.HabitType;

public record HabitCreateRequest(
        String name,
        HabitType type,
        Integer target
) {
}
