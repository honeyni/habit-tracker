package com.example.habittracker.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class CheckIn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "habit_id")
    private Habit habit;

    private LocalDate date;

    public Long getId() {
        return id;
    }

    public Habit getHabit() {
        return habit;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setHabit(Habit habit) {
        this.habit = habit;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
