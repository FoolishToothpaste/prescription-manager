package com.soham.prescription_manager.controller;

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
        return doctorService.getDoctorById(did).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor not found with id : " + did));
    }

    @PostMapping
    public Doctor addDoctor(@Valid @RequestBody Doctor doctor)
    {
        return doctorService.addDoctor(doctor);
    }
}
