package com.soham.prescription_manager.controller;

import com.soham.prescription_manager.model.Patient;
import com.soham.prescription_manager.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController
{
    private final PatientService patientService;

    public PatientController(PatientService patientService)
    {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getAllPatients()
    {
        return patientService.getAllPatients();
    }

    @GetMapping("/{pid}")
    public Patient getPatientById(@PathVariable long pid)
    {
        return patientService.getPatientById(pid);
    }

    @PostMapping
    public Patient addPatient(@Valid @RequestBody Patient patient)
    {
        return patientService.addPatient(patient);
    }

    @DeleteMapping("/{pid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePatientById(@PathVariable long pid)
    {
        patientService.deletePatientById(pid);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllPatients()
    {
        patientService.deleteAllPatients();
    }

    @PutMapping("/{pid}")
    public Patient updatePatientById(@PathVariable long pid, @Valid @RequestBody Patient patient)
    {
        return patientService.updatePatientById(pid, patient);
    }
}
