package com.example.habittracker.entity;

// Classe abstraite = classe "parent" des autres habitudes
public abstract class Habit {

    // Identifiant de l'habitude (unique)
    private Long id;

    // Nom de l'habitude (ex: "Boire de l'eau")
    private String name;

    // Objectif a atteindre (ex: 2 fois par jour)
    private int target;

    // Getter de id
    public Long getId() {
        return id;
    }

    // Setter de id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter de name
    public String getName() {
        return name;
    }

    // Setter de name
    public void setName(String name) {
        this.name = name;
    }

    // Getter de target
    public int getTarget() {
        return target;
    }

    // Setter de target
    public void setTarget(int target) {
        this.target = target;
    }
}
