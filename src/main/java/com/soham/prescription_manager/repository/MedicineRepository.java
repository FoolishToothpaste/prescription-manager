package com.soham.prescription_manager.repository;
import com.soham.prescription_manager.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Long>
{
}
