package com.example.habittracker.dto.request;

import java.time.LocalDate;

public class CheckInCreateRequest {

    private Long habitId;
    private LocalDate date;

    // Constructeurs
    public CheckInCreateRequest() {}

    public CheckInCreateRequest(Long habitId, LocalDate date) {
        this.habitId = habitId;
        this.date = date;
    }

    // Getters et setters
    public Long getHabitId() { return habitId; }
    public void setHabitId(Long habitId) { this.habitId = habitId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}
