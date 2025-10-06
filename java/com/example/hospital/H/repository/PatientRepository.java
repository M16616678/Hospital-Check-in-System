package com.example.hospital.H.repository;

import com.example.hospital.H.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {}
