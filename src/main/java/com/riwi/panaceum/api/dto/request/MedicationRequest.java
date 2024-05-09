package com.riwi.panaceum.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicationRequest {
    @NotBlank(message = "The trade name is required")
    private String name; 
    @NotBlank(message = "The adverse effects field is required")
    private String sideEffects;
    @NotBlank(message = "The active principle is required")
    private String activePrinciple;
    
}
