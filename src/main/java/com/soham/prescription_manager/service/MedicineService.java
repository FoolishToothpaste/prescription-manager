package com.soham.prescription_manager.service;
import com.soham.prescription_manager.dto.medicine.MedicineCreateRequest;
import com.soham.prescription_manager.dto.medicine.MedicinePatchRequest;
import com.soham.prescription_manager.dto.medicine.MedicinePutRequest;
import com.soham.prescription_manager.model.Medicine;
import com.soham.prescription_manager.repository.MedicineRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineService
{
    private final MedicineRepository medicineRepository;

    MedicineService(MedicineRepository medicineRepository)
    {
        this.medicineRepository = medicineRepository;
    }

    public List<Medicine> getAllMedicines()
    {
        return medicineRepository.findAll();
    }

    public Medicine getMedicineById(long id)
    {
        return medicineRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medicine not found with id : " + id));
    }

    public Medicine addMedicine(MedicineCreateRequest medicineCreateRequest)
    {
        Medicine medicine = new Medicine(
                medicineCreateRequest.getName(),
                medicineCreateRequest.getDosage(),
                medicineCreateRequest.getForm()
        );

        return medicineRepository.save(medicine);
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

    public Medicine updateMedicine(long id, MedicinePutRequest medicinePutRequest)
    {
        Medicine existingMedicine = medicineRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The medicine was not found with id : " + id));
        existingMedicine.setDosage(medicinePutRequest.getDosage());
        existingMedicine.setForm(medicinePutRequest.getForm());
        existingMedicine.setName(medicinePutRequest.getName());

        return medicineRepository.save(existingMedicine);
    }

    public Medicine updateMedicineById(long id, MedicinePatchRequest medicinePatchRequest)
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

        return medicineRepository.save(existingMedicine);
    }
}