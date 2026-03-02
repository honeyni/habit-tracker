package com.example.habittracker.mapper;

import com.example.habittracker.dto.response.CheckInResponse;
import com.example.habittracker.entity.CheckIn;
import org.springframework.stereotype.Component;

@Component
public class CheckInMapper {

    public CheckInResponse toResponse(CheckIn checkIn) {
        return new CheckInResponse(checkIn.getId(), checkIn.getHabit().getId(), checkIn.getDate());
    }
}
