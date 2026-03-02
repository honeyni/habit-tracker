package com.example.habittracker.repository;

import com.example.habittracker.entity.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckInRepository extends JpaRepository<CheckIn, Long> {
}
