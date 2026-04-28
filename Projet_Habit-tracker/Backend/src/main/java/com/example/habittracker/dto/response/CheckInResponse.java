package com.example.habittracker.dto.response;

import java.time.LocalDate;

// Donnees renvoyees au client pour un check-in
public class CheckInResponse {

    private Long id;
    private Long habitId;
    private LocalDate date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHabitId() {
        return habitId;
    }

    public void setHabitId(Long habitId) {
        this.habitId = habitId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
