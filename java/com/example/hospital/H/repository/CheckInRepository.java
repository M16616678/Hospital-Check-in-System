package com.example.hospital.H.repository;

import com.example.hospital.H.model.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CheckInRepository extends JpaRepository<CheckIn, Long> {
    List<CheckIn> findByStatus(String status);
}
