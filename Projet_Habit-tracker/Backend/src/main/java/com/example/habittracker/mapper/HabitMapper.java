package com.example.habittracker.mapper;

import com.example.habittracker.dto.response.HabitResponse;
import com.example.habittracker.entity.Habit;
import com.example.habittracker.util.HabitType;
import org.springframework.stereotype.Component;

@Component
public class HabitMapper {

    public HabitResponse toResponse(Habit habit, HabitType type) {
        return new HabitResponse(habit.getId(), habit.getName(), type, habit.getTarget());
    }
}
