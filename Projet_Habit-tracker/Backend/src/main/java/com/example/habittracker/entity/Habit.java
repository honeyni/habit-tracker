package com.example.habittracker.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "habit_kind")
public abstract class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer target;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getTarget() {
        return target;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }
}
