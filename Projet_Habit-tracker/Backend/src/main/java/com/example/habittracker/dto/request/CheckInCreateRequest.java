package com.example.habittracker.dto.request;

// Donnees recues quand on cree un check-in
public class CheckInCreateRequest {
    private int habitId;
    private String date; // format simple: "2026-03-02"

    public int getHabitId() { return habitId; }
    public void setHabitId(int habitId) { this.habitId = habitId; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}
