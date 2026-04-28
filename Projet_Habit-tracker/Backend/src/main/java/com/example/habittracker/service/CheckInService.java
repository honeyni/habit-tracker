package com.example.habittracker.service;

import com.example.habittracker.entity.CheckIn;
import com.example.habittracker.repository.CheckInRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckInService {

    private final CheckInRepository checkInRepository;

    public CheckInService(CheckInRepository checkInRepository) {
        this.checkInRepository = checkInRepository;
    }

    public List<CheckIn> getAllCheckIns() {
        return checkInRepository.findAll();
    }

    public Optional<CheckIn> getCheckInById(Long id) {
        return checkInRepository.findById(id);
    }

    public List<CheckIn> getCheckInsByHabitId(Long habitId) {
        return checkInRepository.findByHabit_Id(habitId);
    }

    public CheckIn createCheckIn(CheckIn checkIn) {
        return checkInRepository.save(checkIn);
    }

    public boolean deleteCheckIn(Long id) {
        if (checkInRepository.existsById(id)) {
            checkInRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
