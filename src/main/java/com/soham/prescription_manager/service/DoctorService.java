package com.soham.prescription_manager.service;

import com.soham.prescription_manager.repository.DoctorRepository;
import org.springframework.stereotype.Service;
import com.soham.prescription_manager.model.Doctor;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService
{
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository)
    {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors()
    {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(long did)
    {
        return doctorRepository.findById(did);
    }

    public Doctor addDoctor(Doctor doctor)
    {
        return doctorRepository.save(doctor);
    }
}
