package com.example.hospital.H.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "checkins")
public class CheckIn {

    /* ========== PRIMARY KEY ========== */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                 // PK of checkins table

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    /* ========== FOREIGN KEY ========== */
    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    /* ========== COLUMNS ========== */
    @NotNull
    @Column(nullable = false)
    private LocalDateTime checkInTime = LocalDateTime.now();

    @NotNull
    @Column(nullable = false)
    private String reason;

    @NotNull
    @Column(nullable = false)
    private String status = "CHECKED_IN";

    /* ========== GETTERS / SETTERS ========== */
    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public LocalDateTime getCheckInTime() { return checkInTime; }
    public void setCheckInTime(LocalDateTime checkInTime) { this.checkInTime = checkInTime; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}