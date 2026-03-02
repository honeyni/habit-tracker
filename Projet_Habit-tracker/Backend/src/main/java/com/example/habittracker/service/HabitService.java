package com.example.habittracker.service;

import com.example.habittracker.dto.request.HabitCreateRequest;
import com.example.habittracker.dto.response.HabitResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HabitService {

    public List<HabitResponse> findAll() {
        return new ArrayList<>();
    }

    public HabitResponse create(HabitCreateRequest request) {
        return new HabitResponse(null, request.name(), request.type(), request.target());
    }
}
