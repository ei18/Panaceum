package com.riwi.panaceum.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentHasMedicationRepository extends JpaRepository<TreatmentHasMedicationRepository, Long> {
    
}
