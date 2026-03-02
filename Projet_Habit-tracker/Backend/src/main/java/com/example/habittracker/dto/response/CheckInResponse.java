package com.example.habittracker.dto.response;

// Donnees renvoyees au client pour un check-in
public class CheckInResponse {
    private int id;
    private int habitId;
    private String date;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getHabitId() { return habitId; }
    public void setHabitId(int habitId) { this.habitId = habitId; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}
