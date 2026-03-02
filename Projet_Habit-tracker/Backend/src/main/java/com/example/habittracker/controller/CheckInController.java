package com.example.habittracker.controller;

import com.example.habittracker.dto.request.CheckInCreateRequest;
import com.example.habittracker.dto.response.CheckInResponse;
import com.example.habittracker.service.CheckInService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/check-ins")
public class CheckInController {

    private final CheckInService checkInService;

    public CheckInController(CheckInService checkInService) {
        this.checkInService = checkInService;
    }

    @GetMapping
    public List<CheckInResponse> getAllCheckIns() {
        return checkInService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CheckInResponse createCheckIn(@RequestBody CheckInCreateRequest request) {
        return checkInService.create(request);
    }
}
