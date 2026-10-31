package com.soham.prescription_manager.controller;

import com.soham.prescription_manager.dto.patient.PatientCreateRequest;
import com.soham.prescription_manager.dto.patient.PatientPatchRequest;
import com.soham.prescription_manager.dto.patient.PatientPutRequest;
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
    public Patient addPatient(@Valid @RequestBody PatientCreateRequest patientCreateRequest)
    {
        return patientService.addPatient(patientCreateRequest);
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
    public Patient updatePatientById(@PathVariable long pid, @Valid @RequestBody PatientPutRequest patientPutRequest)
    {
        return patientService.updatePatientById(pid, patientPutRequest);
    }

    @PatchMapping("/{pid}")
    public Patient updatePatientSelectiveField(@PathVariable long pid, @Valid @RequestBody PatientPatchRequest patientPatchRequest)
    {
        return patientService.updatePatientSelectiveFields(pid, patientPatchRequest);
    }
}
