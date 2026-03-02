package com.example.habittracker;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class HabitServiceTest {

    @Mock
    private HabitRepository habitRepository; // Repository pour persister les habitudes

    @InjectMocks
    private HabitService habitService; // Service qu’on teste

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialiser les mocks
    }

    @Test
    void shouldCreateHabitWhenRequestIsValid() {
        Habit habit = new Habit();
        habit.setName("Boire 2L d'eau");

        when(habitRepository.save(any(Habit.class))).thenReturn(habit);

        Habit created = habitService.createHabit(habit);

        assertNotNull(created);
        assertEquals("Boire 2L d'eau", created.getName());
        verify(habitRepository, times(1)).save(habit);
    }

    @Test
    void shouldToggleHabitCheckedStatus() {
        Habit habit = new Habit();
        habit.setId(1L);
        habit.setChecked(false);

        when(habitRepository.findById(1L)).thenReturn(Optional.of(habit));
        when(habitRepository.save(any(Habit.class))).thenReturn(habit);

        Habit toggled = habitService.toggleHabit(1L);

        assertTrue(toggled.isChecked());
        verify(habitRepository, times(1)).save(habit);
    }

    @Test
    void shouldThrowExceptionWhenHabitNotFound() {
        when(habitRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(HabitNotFoundException.class, () -> {
            habitService.toggleHabit(999L);
        });

        verify(habitRepository, never()).save(any(Habit.class));
    }
}
