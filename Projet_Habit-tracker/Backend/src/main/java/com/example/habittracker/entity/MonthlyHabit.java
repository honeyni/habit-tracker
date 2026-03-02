package com.example.habittracker.entity;

// MonthlyHabit = habitude a faire chaque mois
public class MonthlyHabit extends Habit {

    // Constructeur vide
    public MonthlyHabit() {
    }

    // Constructeur pratique
    public MonthlyHabit(int id, String name, int target) {
        setId(id);
        setName(name);
        setTarget(target);
    }

    // Affichage simple
    @Override
    public String toString() {
        return "MonthlyHabit{id=" + getId()
                + ", name='" + getName() + '\''
                + ", target=" + getTarget()
                + "}";
    }
}
