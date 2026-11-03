package com.soham.prescription_manager.controller;
import com.soham.prescription_manager.dto.medicine.MedicineCreateRequest;
import com.soham.prescription_manager.dto.medicine.MedicinePatchRequest;
import com.soham.prescription_manager.dto.medicine.MedicinePutRequest;
import com.soham.prescription_manager.dto.medicine.MedicineResponse;
import com.soham.prescription_manager.service.MedicineService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


import java.util.List;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController
{
    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService)
    {
        this.medicineService = medicineService;
    }

    @GetMapping
    public List<MedicineResponse> getMedicines()
    {
        return medicineService.getAllMedicines();
    }

    @GetMapping("/{id}")
    public MedicineResponse getMedicineById(@PathVariable Long id)
    {
        return medicineService.getMedicineById(id);
    }

    @PostMapping
    public MedicineResponse postMedicines(@Valid @RequestBody MedicineCreateRequest medicineCreateRequest)
    {
        return medicineService.addMedicine(medicineCreateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMedicineById(@PathVariable Long id)
    {
        medicineService.deleteMedicineById(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllMedicines()
    {
        medicineService.deleteAllMedicines();
    }

    @PutMapping("/{id}")
    public MedicineResponse updateMedicine(@PathVariable long id, @Valid @RequestBody MedicinePutRequest medicinePutRequest)
    {
        return medicineService.updateMedicine(id, medicinePutRequest);
    }

    @PatchMapping("/{id}")
    public MedicineResponse updateMedicineById(@PathVariable long id, @Valid @RequestBody MedicinePatchRequest medicinePatchRequest)
    {
        return medicineService.updateMedicineById(id, medicinePatchRequest);
    }
}