package com.soham.prescription_manager.service;

import com.soham.prescription_manager.repository.DoctorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.soham.prescription_manager.model.Doctor;
import org.springframework.web.server.ResponseStatusException;

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

    public Doctor getDoctorById(long did)
    {
        return doctorRepository.findById(did).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor not found with id : " + did));
    }

    public Doctor addDoctor(Doctor doctor)
    {
        return doctorRepository.save(doctor);
    }

    public void deleteDoctorById(long did)
    {
        if(!doctorRepository.existsById(did))
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor not found with id : " + did);
        }

        doctorRepository.deleteById(did);
    }

    public void deleteAllDoctors()
    {
        doctorRepository.deleteAll();
    }

    public Doctor updateDoctor(long did, Doctor doctor)
    {
        Doctor existingDoctor = doctorRepository.findById(did).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor not found by id : " + did));

        existingDoctor.setDoctorName(doctor.getDoctorName());
        existingDoctor.setDoctorDepartment(doctor.getDoctorDepartment());
        existingDoctor.setDoctorEmail(doctor.getDoctorEmail());
        existingDoctor.setDoctorPhoneNumber(doctor.getDoctorPhoneNumber());

        return doctorRepository.save(existingDoctor);
    }
}
