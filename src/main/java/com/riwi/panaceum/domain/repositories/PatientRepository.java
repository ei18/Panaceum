package com.riwi.panaceum.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.panaceum.domain.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String>{
}
