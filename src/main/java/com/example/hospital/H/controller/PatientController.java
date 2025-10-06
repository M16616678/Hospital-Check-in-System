package com.example.hospital.H.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospital.H.dto.PatientCreateDto;
import com.example.hospital.H.model.Patient;
import com.example.hospital.H.service.PatientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;


@Valid
@RestController
@RequestMapping("/api/patients")
public class PatientController {
	
	private static final org.slf4j.Logger log =
	        org.slf4j.LoggerFactory.getLogger(PatientController.class);
	
	private final PatientService svc;

	public PatientController(PatientService svc) {
		this.svc = svc;
	}

	@PostMapping
	public ResponseEntity<Patient> create(@Valid @RequestBody PatientCreateDto dto,
	                                      HttpServletRequest req) {
	    log.info("Headers: {}", req.getHeader("Content-Type"));
	    log.info("Body dto: {}", dto);
	    log.info(">>>> dto  === {}", dto);
	    Patient saved = svc.create(dto.toEntity());
	    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

	@GetMapping
	@Operation(summary = "List all patients")
	public List<Patient> list() {
		return svc.findAll();
	}

	@GetMapping("/{id}")
	@Operation(summary = "List all patients")
	public ResponseEntity<Patient> get(@PathVariable Long id) {
		return svc.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
}
