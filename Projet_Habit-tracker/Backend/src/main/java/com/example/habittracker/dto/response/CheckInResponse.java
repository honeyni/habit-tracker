package com.example.habittracker.dto.response;

// Donnees renvoyees au client pour un check-in
public class CheckInResponse {
    private Long id;
    private Long habitId;
    private String date;

    public int getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getHabitId() { return habitId; }
    public void setHabitId(Long habitId) { this.habitId = habitId; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}
