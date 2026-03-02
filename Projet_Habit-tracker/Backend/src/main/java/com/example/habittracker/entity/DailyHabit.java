package com.example.habittracker.entity;

// DailyHabit = habitude a faire chaque jour
public class DailyHabit extends Habit {

    // Constructeur vide (obligatoire dans beaucoup de cas)
    public DailyHabit() {
    }

    // Constructeur pratique pour creer rapidement une habitude quotidienne
    public DailyHabit(int id, String name, int target) {
        setId(id);
        setName(name);
        setTarget(target);
    }

    // Methode d'affichage simple (utile pour debug)
    @Override
    public String toString() {
        return "DailyHabit{id=" + getId()
                + ", name='" + getName() + '\''
                + ", target=" + getTarget()
                + "}";
    }
}
