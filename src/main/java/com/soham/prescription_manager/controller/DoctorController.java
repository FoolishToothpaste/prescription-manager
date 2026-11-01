package com.soham.prescription_manager.controller;

import com.soham.prescription_manager.dto.doctor.DoctorCreateRequest;
import com.soham.prescription_manager.dto.doctor.DoctorPatchRequest;
import com.soham.prescription_manager.dto.doctor.DoctorPutRequest;
import com.soham.prescription_manager.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.soham.prescription_manager.model.Doctor;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController
{
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService)
    {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> getAllDoctors()
    {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{did}")
    public Doctor getDoctorById(@PathVariable Long did)
    {
        return doctorService.getDoctorById(did);
    }

    @PostMapping
    public Doctor addDoctor(@Valid @RequestBody DoctorCreateRequest doctorCreateRequest)
    {
        return doctorService.addDoctor(doctorCreateRequest);
    }

    @DeleteMapping("/{did}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDoctorById(@PathVariable Long did)
    {
        doctorService.deleteDoctorById(did);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllDoctors()
    {
        doctorService.deleteAllDoctors();
    }

    @PutMapping("/{did}")
    public Doctor updateDoctor(@PathVariable long did, @Valid @RequestBody DoctorPutRequest doctorPutRequest)
    {
        return doctorService.updateDoctor(did, doctorPutRequest);
    }

    @PatchMapping("/{did}")
    public Doctor updateDoctorById(@PathVariable long did, @Valid @RequestBody DoctorPatchRequest doctorPatchRequest)
    {
        return doctorService.updateDoctorById(did, doctorPatchRequest);
    }
}
