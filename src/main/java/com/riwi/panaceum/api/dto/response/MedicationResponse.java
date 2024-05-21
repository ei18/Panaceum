package com.riwi.panaceum.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicationResponse {
    private Long id; 
    private String name; 
    private String sideEffects;
    private String activePrinciple;
   
}
