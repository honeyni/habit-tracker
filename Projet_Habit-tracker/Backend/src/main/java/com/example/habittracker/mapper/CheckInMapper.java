package com.example.habittracker.mapper;

import com.example.habittracker.dto.response.CheckInResponse;
import com.example.habittracker.entity.CheckIn;
import org.springframework.stereotype.Component;

@Component
public class CheckInMapper {

    public CheckInResponse toResponse(CheckIn checkIn) {

        CheckInResponse response = new CheckInResponse();

        response.setId(checkIn.getId());

        // 🔥 correction ici
        response.setHabitId(checkIn.getHabit().getId());

        response.setDate(checkIn.getDate());

        return response;
    }
}
