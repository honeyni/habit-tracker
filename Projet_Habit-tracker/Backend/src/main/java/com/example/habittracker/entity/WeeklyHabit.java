package com.example.habittracker.entity;

// WeeklyHabit = habitude a faire chaque semaine
public class WeeklyHabit extends Habit {

    // Constructeur vide
    public WeeklyHabit() {
    }

    // Constructeur pratique
    public WeeklyHabit(Long id, String name, Long target) {
        setId(id);
        setName(name);
        setTarget(target);
    }

    // Affichage simple
    @Override
    public String toString() {
        return "WeeklyHabit{id=" + getId()
                + ", name='" + getName() + '\''
                + ", target=" + getTarget()
                + "}";
    }
}
