package com.example.habittracker.service;

import com.example.habittracker.entity.CheckIn;
import com.example.habittracker.repository.CheckInRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Service = logique metier pour les check-ins
@Service
public class CheckInService {

    private final CheckInRepository checkInRepository;

    // Injection du repository par constructeur
    public CheckInService(CheckInRepository checkInRepository) {
        this.checkInRepository = checkInRepository;
    }

    // Recuperer tous les check-ins
    public List<CheckIn> getAllCheckIns() {
        return checkInRepository.findAll();
    }

    // Recuperer un check-in par id
    public Optional<CheckIn> getCheckInById(int id) {
        return checkInRepository.findById(id);
    }

    // Recuperer tous les check-ins d'une habitude
    public List<CheckIn> getCheckInsByHabitId(int habitId) {
        return checkInRepository.findByHabitId(habitId);
    }

    // Creer un check-in
    public CheckIn createCheckIn(CheckIn checkIn) {
        return checkInRepository.save(checkIn);
    }

    // Supprimer un check-in
    public boolean deleteCheckIn(int id) {
        if (checkInRepository.existsById(id)) {
            checkInRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
