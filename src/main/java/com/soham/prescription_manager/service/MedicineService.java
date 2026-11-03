package com.soham.prescription_manager.service;
import com.soham.prescription_manager.dto.medicine.MedicineCreateRequest;
import com.soham.prescription_manager.dto.medicine.MedicinePatchRequest;
import com.soham.prescription_manager.dto.medicine.MedicinePutRequest;
import com.soham.prescription_manager.dto.medicine.MedicineResponse;
import com.soham.prescription_manager.model.Medicine;
import com.soham.prescription_manager.repository.MedicineRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicineService
{
    private final MedicineRepository medicineRepository;

    MedicineService(MedicineRepository medicineRepository)
    {
        this.medicineRepository = medicineRepository;
    }

    private MedicineResponse medicineResponseMapping(Medicine medicine)
    {
        return new MedicineResponse(
                medicine.getId(),
                medicine.getName(),
                medicine.getDosage(),
                medicine.getForm()
        );
    }

    public List<MedicineResponse> getAllMedicines()
    {
        List<Medicine> medicineList = medicineRepository.findAll();
        List<MedicineResponse> medicineResponseList = new ArrayList<>();

        for(Medicine medicine : medicineList)
        {
            medicineResponseList.add(medicineResponseMapping(medicine));
        }

        return medicineResponseList;
    }

    public MedicineResponse getMedicineById(long id)
    {
        return medicineResponseMapping(
                medicineRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medicine not found with id : " + id))
        );
    }

    public MedicineResponse addMedicine(MedicineCreateRequest medicineCreateRequest)
    {
        Medicine medicine = new Medicine(
                medicineCreateRequest.getName(),
                medicineCreateRequest.getDosage(),
                medicineCreateRequest.getForm()
        );

        return medicineResponseMapping(medicineRepository.save(medicine));
    }

    public void deleteMedicineById(long id)
    {
        if(!medicineRepository.existsById(id))
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The Medicine to be deleted not found with id : " + id);
        }
        medicineRepository.deleteById(id);
    }

    public void deleteAllMedicines()
    {
        medicineRepository.deleteAll();
    }

    public MedicineResponse updateMedicine(long id, MedicinePutRequest medicinePutRequest)
    {
        Medicine existingMedicine = medicineRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The medicine was not found with id : " + id));
        existingMedicine.setDosage(medicinePutRequest.getDosage());
        existingMedicine.setForm(medicinePutRequest.getForm());
        existingMedicine.setName(medicinePutRequest.getName());

        return medicineResponseMapping(medicineRepository.save(existingMedicine));
    }

    public MedicineResponse updateMedicineById(long id, MedicinePatchRequest medicinePatchRequest)
    {
        Medicine existingMedicine = medicineRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medicine not found with id : " + id));
        if(medicinePatchRequest.getName() != null)
        {
            existingMedicine.setName(medicinePatchRequest.getName());
        }

        if(medicinePatchRequest.getDosage() != null)
        {
            existingMedicine.setDosage(medicinePatchRequest.getDosage());
        }

        if(medicinePatchRequest.getForm() != null)
        {
            existingMedicine.setForm(medicinePatchRequest.getForm());
        }

        return medicineResponseMapping(medicineRepository.save(existingMedicine));
    }
}