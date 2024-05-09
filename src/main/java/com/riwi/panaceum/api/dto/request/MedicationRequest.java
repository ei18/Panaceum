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
    @NotBlank(message = "El nombre comercial es requerido")
    private String name; 
    @NotBlank(message = "El campo de efectos adversos es requerido")
    private String sideEffects;
    @NotBlank(message = "El principio activo es requerido")
    private String activePrinciple;
    
}
