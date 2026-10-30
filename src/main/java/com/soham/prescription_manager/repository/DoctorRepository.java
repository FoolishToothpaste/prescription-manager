package com.soham.prescription_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.soham.prescription_manager.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>
{}
