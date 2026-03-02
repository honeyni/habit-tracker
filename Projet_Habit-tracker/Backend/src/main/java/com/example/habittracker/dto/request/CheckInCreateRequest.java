package com.example.habittracker.dto.request;

import java.time.LocalDate;

public record CheckInCreateRequest(
        Long habitId,
        LocalDate date
) {
}
