package com.soham.prescription_manager.service;
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

    public Optional<Medicine> getMedicineById(long id)
    {
        return medicineRepository.findById(id);
    }

    public Medicine addMedicine(Medicine medicine)
    {
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

    public Medicine updateMedicine(long id, Medicine medicine)
    {
        Medicine existingMedicine = medicineRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The medicine was not found with id : " + id));
        existingMedicine.setDosage(medicine.getDosage());
        existingMedicine.setForm(medicine.getForm());
        existingMedicine.setName(medicine.getName());

        return medicineRepository.save(existingMedicine);
    }
}
