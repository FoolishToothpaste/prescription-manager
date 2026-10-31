package com.soham.prescription_manager.controller;
import com.soham.prescription_manager.model.Medicine;
import com.soham.prescription_manager.service.MedicineService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController
{
    private final MedicineService medicineService;

    MedicineController(MedicineService medicineService)
    {
        this.medicineService = medicineService;
    }

    @GetMapping
    public List<Medicine> getMedicines()
    {
        return medicineService.getAllMedicines();
    }

    @GetMapping("/{id}")
    public Medicine getMedicineById(@PathVariable Long id)
    {
        return medicineService.getMedicineById(id);
    }

    @PostMapping
    public Medicine postMedicines(@Valid @RequestBody Medicine medicine)
    {
        return medicineService.addMedicine(medicine);
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
    public Medicine updateMedicine(@PathVariable long id, @Valid @RequestBody Medicine medicine)
    {
        return medicineService.updateMedicine(id, medicine);
    }
}
