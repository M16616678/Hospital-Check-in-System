package com.example.hospital.H.dto;

import java.time.LocalDate;

import com.example.hospital.H.model.Patient;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PatientCreateDto(@JsonProperty("firstName") @NotBlank String firstName,
		@JsonProperty("lastName") @NotBlank String lastName, @JsonProperty("email") @Email String email,
		@JsonProperty("phone") @NotBlank String phone, @JsonProperty("dob") @NotNull LocalDate dob) {

	@JsonCreator // ← tell Jackson to use the canonical constructor
	public PatientCreateDto {
	}

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