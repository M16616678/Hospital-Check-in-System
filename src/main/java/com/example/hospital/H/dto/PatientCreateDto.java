package com.example.hospital.H.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import com.example.hospital.H.model.Patient;

public record PatientCreateDto(
        @NotBlank String firstName,
        @NotBlank String lastName,
        @Email   String email,
        @NotBlank String phone,
        @NotNull  LocalDate dob) {

    public Patient toEntity() {
        Patient p = new Patient();
        p.setFirstName(firstName.trim());
        p.setLastName(lastName.trim());
        p.setEmail(email.trim());
        p.setPhone(phone.trim());
        p.setDob(dob);
        return p;
    }
}