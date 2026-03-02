package com.example.habittracker.entity;

// CheckIn = validation d'une habitude a une date
public class CheckIn {

    // Identifiant du check-in
    private int id;

    // Id de l'habitude liee a ce check-in
    private int habitId;

    // Date du check-in (format simple: "2026-03-02")
    private String date;

    // Constructeur vide
    public CheckIn() {
    }

    // Constructeur pratique
    public CheckIn(int id, int habitId, String date) {
        this.id = id;
        this.habitId = habitId;
        this.date = date;
    }

    // Getter de id
    public int getId() {
        return id;
    }

    // Setter de id
    public void setId(int id) {
        this.id = id;
    }

    // Getter de habitId
    public int getHabitId() {
        return habitId;
    }

    // Setter de habitId
    public void setHabitId(int habitId) {
        this.habitId = habitId;
    }

    // Getter de date
    public String getDate() {
        return date;
    }

    // Setter de date
    public void setDate(String date) {
        this.date = date;
    }

    // Affichage simple
    @Override
    public String toString() {
        return "CheckIn{id=" + id
                + ", habitId=" + habitId
                + ", date='" + date + '\''
                + "}";
    }
}
