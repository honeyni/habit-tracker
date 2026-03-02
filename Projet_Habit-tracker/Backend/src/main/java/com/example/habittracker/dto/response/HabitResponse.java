package com.example.habittracker.dto.response;

// Donnees renvoyees au client pour une habitude
public class HabitResponse {
    private int id;
    private String name;
    private int target;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getTarget() { return target; }
    public void setTarget(int target) { this.target = target; }
}
