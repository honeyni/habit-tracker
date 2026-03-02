package com.example.habittracker.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("WEEKLY")
public class WeeklyHabit extends Habit {
}
