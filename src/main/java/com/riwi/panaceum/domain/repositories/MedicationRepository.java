package com.riwi.panaceum.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.panaceum.domain.entities.Medication;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long>{
 
}
