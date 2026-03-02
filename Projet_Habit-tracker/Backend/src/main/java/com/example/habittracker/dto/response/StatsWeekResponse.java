package com.example.habittracker.dto.response;

public class StatsWeekResponse {

    private int totalHabits;
    private int completedThisWeek;
    private double completionRate;

    // Constructeurs
    public StatsWeekResponse() {}

    public StatsWeekResponse(int totalHabits, int completedThisWeek, double completionRate) {
        this.totalHabits = totalHabits;
        this.completedThisWeek = completedThisWeek;
        this.completionRate = completionRate;
    }

    // Getters et setters
    public int getTotalHabits() { return totalHabits; }
    public void setTotalHabits(int totalHabits) { this.totalHabits = totalHabits; }

    public int getCompletedThisWeek() { return completedThisWeek; }
    public void setCompletedThisWeek(int completedThisWeek) { this.completedThisWeek = completedThisWeek; }

    public double getCompletionRate() { return completionRate; }
    public void setCompletionRate(double completionRate) { this.completionRate = completionRate; }
}
