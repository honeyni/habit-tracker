package com.example.habittracker.dto.response;

import java.time.LocalDate;

public record CheckInResponse(
        Long id,
        Long habitId,
        LocalDate date
) {
}
