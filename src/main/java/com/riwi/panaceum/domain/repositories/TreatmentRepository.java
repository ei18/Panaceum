package com.riwi.panaceum.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.panaceum.domain.entities.Treatment;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
    
}
