package com.example.habittracker.dto.response;

// Donnees renvoyees pour les stats de la semaine
public class StatsWeekResponse {
    private int totalHabits;
    private int totalCheckIns;
    private double completionRate;

    public int getTotalHabits() { return totalHabits; }
    public void setTotalHabits(int totalHabits) { this.totalHabits = totalHabits; }

    public int getTotalCheckIns() { return totalCheckIns; }
    public void setTotalCheckIns(int totalCheckIns) { this.totalCheckIns = totalCheckIns; }

    public double getCompletionRate() { return completionRate; }
    public void setCompletionRate(double completionRate) { this.completionRate = completionRate; }
}
