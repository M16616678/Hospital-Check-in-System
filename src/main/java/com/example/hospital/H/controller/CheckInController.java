package com.example.hospital.H.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; // Correct import
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospital.H.model.CheckIn;
import com.example.hospital.H.service.CheckInService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/checkins")
public class CheckInController {
    private final CheckInService svc;

    public CheckInController(CheckInService svc) {
        this.svc = svc;
    }

    @PostMapping
    @Operation(summary = "Register a new patient")
    public ResponseEntity<CheckIn> create(@Valid @RequestBody CheckIn request) {
        CheckIn ci = svc.create(request.getId(), request.getReason());
        return ResponseEntity.status(HttpStatus.CREATED).body(ci);
    }

    @GetMapping
    @Operation(summary = "List all patients")
    public List<CheckIn> list() {
        return svc.list();
    }
}