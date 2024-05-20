package com.riwi.panaceum.api.dto.response;

import java.time.LocalDate;

import com.riwi.panaceum.utils.enums.StateTreatment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentResponse {
    private Long id; 
    private LocalDate startDate;
    private LocalDate finalDate;
    private String dosage;
    private String frequency; 
    private String doctor; 
    private StateTreatment state;
    private PatientResponse patient;
} 
