package com.example.habittracker.dto.response;

import com.example.habittracker.util.HabitType;

public class HabitResponse {

    private Long id;
    private String name;
    private String description;
    private HabitType type;

    // Constructeurs
    public HabitResponse() {}

    public HabitResponse(Long id, String name, String description, HabitType type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public HabitType getType() { return type; }
    public void setType(HabitType type) { this.type = type; }
}
