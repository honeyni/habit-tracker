package com.example.habittracker.dto.request;

// Donnees recues quand on cree une habitude
public class HabitCreateRequest {
    private String name;
    private int target;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getTarget() { return target; }
    public void setTarget(int target) { this.target = target; }
}
