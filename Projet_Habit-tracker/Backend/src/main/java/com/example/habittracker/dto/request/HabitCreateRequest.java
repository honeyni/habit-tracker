package com.example.habittracker.dto.request;

import com.example.habittracker.util.HabitType;

public class HabitCreateRequest {

    private String name;
    private String description;
    private HabitType type;

    // Constructeurs
    public HabitCreateRequest() {}

    public HabitCreateRequest(String name, String description, HabitType type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    // Getters et setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public HabitType getType() { return type; }
    public void setType(HabitType type) { this.type = type; }
}
