package com.example.hospital.H.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.hospital.H.model.Patient;
import com.example.hospital.H.repository.PatientRepository;

@Service
public class PatientService {
    private final PatientRepository repo;

    public PatientService(PatientRepository repo) {
        this.repo = repo;
    }

    public Patient create(Patient p) { return repo.save(p); }
    public Optional<Patient> findById(Long id) { return repo.findById(id); }
    public List<Patient> findAll() { return repo.findAll(); }
}
