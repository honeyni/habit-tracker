package com.example.habittracker;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CheckInServiceTest {

    @Mock
    private HabitRepository habitRepository; // Repository pour les habitudes

    @Mock
    private CheckInRepository checkInRepository; // Repository pour les check-ins

    @InjectMocks
    private CheckInService checkInService; // Service qu’on teste

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateCheckInWhenHabitExists() {
        Habit habit = new Habit();
        habit.setId(1L);
        habit.setName("Méditer 10 min");

        when(habitRepository.findById(1L)).thenReturn(Optional.of(habit));

        CheckIn checkIn = new CheckIn();
        checkIn.setHabit(habit);
        checkIn.setDate(LocalDate.now());

        when(checkInRepository.save(any(CheckIn.class))).thenReturn(checkIn);

        CheckIn created = checkInService.createCheckIn(1L);

        assertNotNull(created);
        assertEquals(habit, created.getHabit());
        assertEquals(LocalDate.now(), created.getDate());

        verify(checkInRepository, times(1)).save(any(CheckIn.class));
    }

    @Test
    void shouldThrowExceptionWhenHabitDoesNotExist() {
        when(habitRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(HabitNotFoundException.class, () -> {
            checkInService.createCheckIn(999L);
        });

        verify(checkInRepository, never()).save(any(CheckIn.class));
    }

    @Test
    void shouldNotCreateDuplicateCheckInForSameDay() {
        Habit habit = new Habit();
        habit.setId(1L);

        CheckIn existingCheckIn = new CheckIn();
        existingCheckIn.setHabit(habit);
        existingCheckIn.setDate(LocalDate.now());

        when(habitRepository.findById(1L)).thenReturn(Optional.of(habit));
        when(checkInRepository.findByHabitIdAndDate(1L, LocalDate.now()))
                .thenReturn(Optional.of(existingCheckIn));

        CheckIn checkIn = checkInService.createCheckIn(1L);

        // Si check-in déjà présent, on retourne l’existant
        assertEquals(existingCheckIn, checkIn);
        verify(checkInRepository, never()).save(any(CheckIn.class));
    }
}
