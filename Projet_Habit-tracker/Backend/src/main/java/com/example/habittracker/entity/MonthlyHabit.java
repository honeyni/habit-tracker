package com.example.habittracker.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MONTHLY")
public class MonthlyHabit extends Habit {
}
