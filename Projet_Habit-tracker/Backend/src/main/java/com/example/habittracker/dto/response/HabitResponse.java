package com.example.habittracker.dto.response;

import com.example.habittracker.util.HabitType;

public record HabitResponse(
        Long id,
        String name,
        HabitType type,
        Integer target
) {
}
