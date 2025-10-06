package com.example.hospital.H.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.hospital.H.exception.PatientNotFoundException;
import com.example.hospital.H.model.CheckIn;
import com.example.hospital.H.model.Patient;
import com.example.hospital.H.repository.CheckInRepository;
import com.example.hospital.H.repository.PatientRepository;

@Service
public class CheckInService {

    private final CheckInRepository checkInRepo;
    private final PatientRepository patientRepo;

    public CheckInService(CheckInRepository cRepo, PatientRepository pRepo) {
        this.checkInRepo = cRepo;
        this.patientRepo = pRepo;
    }

    public CheckIn create(Long patientId, String reason) {
        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException(patientId));
        CheckIn ci = new CheckIn();
        ci.setPatient(patient);
        ci.setReason(reason);
        ci.setStatus("CHECKED_IN");
        return checkInRepo.save(ci);
    }

    public List<CheckIn> list() {
        return checkInRepo.findAll();
    }

    public Optional<CheckIn> findById(Long id) {
        return checkInRepo.findById(id);
    }
}