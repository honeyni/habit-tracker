package com.example.habittracker.util;

import java.time.DayOfWeek;
import java.time.LocalDate;

public final class DateUtils {

    private DateUtils() {
    }

    public static LocalDate startOfWeek(LocalDate date) {
        return date.with(DayOfWeek.MONDAY);
    }

    public static LocalDate endOfWeek(LocalDate date) {
        return date.with(DayOfWeek.SUNDAY);
    }
}
