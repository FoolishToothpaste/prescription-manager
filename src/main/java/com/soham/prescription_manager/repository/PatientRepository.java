package com.soham.prescription_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.soham.prescription_manager.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>
{}
