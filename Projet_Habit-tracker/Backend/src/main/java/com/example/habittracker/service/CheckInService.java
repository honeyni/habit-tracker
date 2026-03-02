package com.example.habittracker.service;

import com.example.habittracker.dto.request.CheckInCreateRequest;
import com.example.habittracker.dto.response.CheckInResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheckInService {

    public List<CheckInResponse> findAll() {
        return new ArrayList<>();
    }

    public CheckInResponse create(CheckInCreateRequest request) {
        return new CheckInResponse(null, request.habitId(), request.date());
    }
}
