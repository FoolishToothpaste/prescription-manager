package com.soham.prescription_manager.service;

import com.soham.prescription_manager.dto.doctor.DoctorCreateRequest;
import com.soham.prescription_manager.dto.doctor.DoctorPatchRequest;
import com.soham.prescription_manager.dto.doctor.DoctorPutRequest;
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

    public Doctor addDoctor(DoctorCreateRequest doctorCreateRequest)
    {
        System.out.println(doctorCreateRequest.getDoctorName());
        System.out.println(doctorCreateRequest.getDoctorDepartment());
        System.out.println(doctorCreateRequest.getDoctorPhoneNumber());
        System.out.println(doctorCreateRequest.getDoctorEmail());

        Doctor doctor = new Doctor(
                doctorCreateRequest.getDoctorName(),
                doctorCreateRequest.getDoctorDepartment(),
                doctorCreateRequest.getDoctorPhoneNumber(),
                doctorCreateRequest.getDoctorEmail()
        );
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

    public Doctor updateDoctor(long did, DoctorPutRequest doctorPutRequest)
    {
        Doctor existingDoctor = doctorRepository.findById(did).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor not found by id : " + did));

        existingDoctor.setDoctorName(doctorPutRequest.getDoctorName());
        existingDoctor.setDoctorDepartment(doctorPutRequest.getDoctorDepartment());
        existingDoctor.setDoctorEmail(doctorPutRequest.getDoctorEmail());
        existingDoctor.setDoctorPhoneNumber(doctorPutRequest.getDoctorPhoneNumber());

        return doctorRepository.save(existingDoctor);
    }

    public Doctor updateDoctorById(long did, DoctorPatchRequest doctorPatchRequest)
    {
        Doctor existingDoctor = doctorRepository.findById(did).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor not found with id : " + did));

        if(doctorPatchRequest.getDoctorName() != null)
        {
            existingDoctor.setDoctorName(doctorPatchRequest.getDoctorName());
        }

        if(doctorPatchRequest.getDoctorDepartment() != null)
        {
            existingDoctor.setDoctorDepartment(doctorPatchRequest.getDoctorDepartment());
        }

        if(doctorPatchRequest.getDoctorPhoneNumber() != null)
        {
            existingDoctor.setDoctorPhoneNumber(doctorPatchRequest.getDoctorPhoneNumber());
        }

        if(doctorPatchRequest.getDoctorEmail() != null)
        {
            existingDoctor.setDoctorEmail(doctorPatchRequest.getDoctorEmail());
        }

        return  doctorRepository.save(existingDoctor);
    }
}
