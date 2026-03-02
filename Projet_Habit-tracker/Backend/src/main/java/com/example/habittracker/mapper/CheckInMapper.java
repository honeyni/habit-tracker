package com.example.habittracker.mapper;

import com.example.habittracker.dto.response.CheckInResponse;
import com.example.habittracker.entity.CheckIn;
import org.springframework.stereotype.Component;

// Transforme une entite CheckIn en CheckInResponse
@Component
public class CheckInMapper {

    public CheckInResponse toResponse(CheckIn checkIn) {
        CheckInResponse response = new CheckInResponse();
        response.setId(checkIn.getId());
        response.setHabitId(checkIn.getHabitId());
        response.setDate(checkIn.getDate());
        return response;
    }
}
