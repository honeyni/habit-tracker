package com.example.habittracker.mapper;

import com.example.habittracker.dto.response.HabitResponse;
import com.example.habittracker.entity.Habit;
import org.springframework.stereotype.Component;

// Transforme une entite Habit en HabitResponse
@Component
public class HabitMapper {

    public HabitResponse toResponse(Habit habit) {
        HabitResponse response = new HabitResponse();
        response.setId(habit.getId());
        response.setName(habit.getName());
        response.setTarget(habit.getTarget());
        return response;
    }
}
