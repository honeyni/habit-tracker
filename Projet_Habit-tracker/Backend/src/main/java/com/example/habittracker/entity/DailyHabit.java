package com.example.habittracker.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DAILY")
public class DailyHabit extends Habit {
}
