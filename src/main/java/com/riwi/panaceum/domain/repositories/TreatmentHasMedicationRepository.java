package com.riwi.panaceum.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.panaceum.domain.entities.TreatmentHasMedication;

@Repository
public interface TreatmentHasMedicationRepository extends JpaRepository<TreatmentHasMedication, Long> {
    
}
