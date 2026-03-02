package com.example.habittracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.habittracker.model.CheckIn;
import com.example.habittracker.service.CheckInService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/check-ins")
@CrossOrigin(origins = "*")
public class CheckInController {

    @Autowired
    private CheckInService checkInService;

    /**
     * POST /api/check-ins
     * Create a new check-in for a habit
     */
    @PostMapping
    public ResponseEntity<CheckIn> createCheckIn(@RequestBody CheckIn checkIn) {
        try {
            CheckIn createdCheckIn = checkInService.createCheckIn(checkIn);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCheckIn);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * GET /api/check-ins?habitId=1
     * Get all check-ins for a specific habit
     */
    @GetMapping
    public ResponseEntity<List<CheckIn>> getCheckInsByHabit(@RequestParam Long habitId) {
        try {
            List<CheckIn> checkIns = checkInService.getCheckInsByHabitId(habitId);
            return ResponseEntity.ok(checkIns);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * GET /api/check-ins/{id}
     * Get a specific check-in by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<CheckIn> getCheckInById(@PathVariable Long id) {
        try {
            CheckIn checkIn = checkInService.getCheckInById(id);
            return ResponseEntity.ok(checkIn);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * GET /api/check-ins/habit/{habitId}/date?date=2026-03-02
     * Get check-ins for a specific habit on a specific date
     */
    @GetMapping("/habit/{habitId}/date")
    public ResponseEntity<List<CheckIn>> getCheckInsByHabitAndDate(
            @PathVariable Long habitId,
            @RequestParam LocalDate date) {
        try {
            List<CheckIn> checkIns = checkInService.getCheckInsByHabitAndDate(habitId, date);
            return ResponseEntity.ok(checkIns);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * PUT /api/check-ins/{id}
     * Update an existing check-in
     */
    @PutMapping("/{id}")
    public ResponseEntity<CheckIn> updateCheckIn(
            @PathVariable Long id,
            @RequestBody CheckIn checkIn) {
        try {
            CheckIn updatedCheckIn = checkInService.updateCheckIn(id, checkIn);
            return ResponseEntity.ok(updatedCheckIn);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/check-ins/{id}
     * Delete a check-in
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCheckIn(@PathVariable Long id) {
        try {
            checkInService.deleteCheckIn(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}