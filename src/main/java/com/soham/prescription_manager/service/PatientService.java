package com.soham.prescription_manager.service;

import com.soham.prescription_manager.model.Patient;
import com.soham.prescription_manager.repository.PatientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PatientService
{
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository)
    {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients()
    {
        return patientRepository.findAll();
    }

    public Patient getPatientById(long pid)
    {
        return patientRepository.findById(pid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found with id : " + pid));
    }

    public Patient addPatient(Patient patient)
    {
        return patientRepository.save(patient);
    }

    public void deletePatientById(long pid)
    {
        if(!patientRepository.existsById(pid))
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found with id + " + pid);
        }
        patientRepository.deleteById(pid);
    }

    public void deleteAllPatients()
    {
        patientRepository.deleteAll();
    }

    public Patient updatePatientById(long pid, Patient patient)
    {
        Patient existingPatient = patientRepository.findById(pid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found with id : " + pid));
        existingPatient.setPatientName(patient.getPatientName());
        existingPatient.setPatientEmail(patient.getPatientEmail());
        existingPatient.setPatientPhoneNumber(patient.getPatientPhoneNumber());

        return patientRepository.save(existingPatient);
    }
}
