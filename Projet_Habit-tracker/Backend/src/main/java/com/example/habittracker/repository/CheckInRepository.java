package com.example.habittracker.repository;

import com.example.habittracker.entity.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CheckInRepository extends JpaRepository<CheckIn, Long> {

    List<CheckIn> findByHabit_Id(Long habitId);

    List<CheckIn> findByHabit_IdAndDateBetween(
            Long habitId,
            LocalDate startDate,
            LocalDate endDate
    );
}
