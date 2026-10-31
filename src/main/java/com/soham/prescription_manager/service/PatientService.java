package com.soham.prescription_manager.service;

import com.soham.prescription_manager.dto.patient.PatientCreateRequest;
import com.soham.prescription_manager.dto.patient.PatientPatchRequest;
import com.soham.prescription_manager.dto.patient.PatientPutRequest;
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

    public Patient addPatient(PatientCreateRequest patientCreateRequest)
    {
        Patient patient = new Patient(
                patientCreateRequest.getPatientName(),
                patientCreateRequest.getPatientPhoneNumber(),
                patientCreateRequest.getPatientEmail()
        );
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

    public Patient updatePatientById(long pid, PatientPutRequest patientPutRequest)
    {
        Patient existingPatient = patientRepository.findById(pid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found with id : " + pid));
        existingPatient.setPatientName(patientPutRequest.getPatientName());
        existingPatient.setPatientEmail(patientPutRequest.getPatientEmail());
        existingPatient.setPatientPhoneNumber(patientPutRequest.getPatientPhoneNumber());

        return patientRepository.save(existingPatient);
    }

    public Patient updatePatientSelectiveFields(long pid, PatientPatchRequest patientPatchRequest)
    {
        Patient existingPatient = patientRepository.findById(pid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found with id : " + pid));

        if(patientPatchRequest.getPatientName() != null)
        {
            existingPatient.setPatientName(patientPatchRequest.getPatientName());
        }

        if(patientPatchRequest.getPatientEmail() != null)
        {
            existingPatient.setPatientEmail(patientPatchRequest.getPatientEmail());
        }

        if(patientPatchRequest.getPatientPhoneNumber() != null)
        {
            existingPatient.setPatientPhoneNumber(patientPatchRequest.getPatientPhoneNumber());
        }

        return patientRepository.save(existingPatient);
    }
}
