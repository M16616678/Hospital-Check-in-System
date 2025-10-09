package com.example.hospital.H.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.H.model.CheckIn;
import com.example.hospital.H.model.Patient;
import com.example.hospital.H.repository.CheckInRepository;

@Service
public class CheckInService {
    private final CheckInRepository checkInRepository;
    private final PatientService patientService;

    @Autowired
    public CheckInService(CheckInRepository checkInRepository, PatientService patientService) {
        this.checkInRepository = checkInRepository;
        this.patientService = patientService;
    }

    public CheckIn create(Long patientId, String reason) {
        Patient patient = patientService.getPatientById(patientId)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found with ID: " + patientId));

        CheckIn checkIn = new CheckIn();
        checkIn.setPatient(patient);
        checkIn.setReason(reason);
        // The CheckIn model already defaults checkInTime and status

        return checkInRepository.save(checkIn);
    }

    public List<CheckIn> list() {
        return checkInRepository.findAll();
    }
}	