package com.soham.prescription_manager.service;

import com.soham.prescription_manager.dto.patient.PatientCreateRequest;
import com.soham.prescription_manager.dto.patient.PatientPatchRequest;
import com.soham.prescription_manager.dto.patient.PatientPutRequest;
import com.soham.prescription_manager.dto.patient.PatientResponse;
import com.soham.prescription_manager.model.Patient;
import com.soham.prescription_manager.repository.PatientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService
{
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository)
    {
        this.patientRepository = patientRepository;
    }

    private PatientResponse patientResponseMapping(Patient patient)
    {
        return new PatientResponse(patient.getPatientId(),
                patient.getPatientName(),
                patient.getPatientEmail());
    }

    public List<PatientResponse> getAllPatients()
    {
        List<Patient> patientList = patientRepository.findAll();
        List<PatientResponse> patientResponseList = new ArrayList<>();

        for (Patient patient : patientList) {
            patientResponseList.add(patientResponseMapping(patient));
        }

        return patientResponseList;
    }

    public PatientResponse getPatientById(long pid)
    {
        Patient patient = patientRepository.findById(pid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found with id + " + pid));

        return patientResponseMapping(patient);
    }

    public PatientResponse addPatient(PatientCreateRequest patientCreateRequest)
    {
        Patient patient = new Patient(
                patientCreateRequest.getPatientName(),
                patientCreateRequest.getPatientPhoneNumber(),
                patientCreateRequest.getPatientEmail()
        );

        return patientResponseMapping(patientRepository.save(patient));
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

    public PatientResponse updatePatientById(long pid, PatientPutRequest patientPutRequest)
    {
        Patient existingPatient = patientRepository.findById(pid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found with id : " + pid));
        existingPatient.setPatientName(patientPutRequest.getPatientName());
        existingPatient.setPatientEmail(patientPutRequest.getPatientEmail());
        existingPatient.setPatientPhoneNumber(patientPutRequest.getPatientPhoneNumber());

        return patientResponseMapping(patientRepository.save(existingPatient));
    }

    public PatientResponse updatePatientSelectiveFields(long pid, PatientPatchRequest patientPatchRequest)
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

        return patientResponseMapping(patientRepository.save(existingPatient));
    }
}
