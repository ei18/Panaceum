package com.riwi.panaceum.api.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentHasMedicationRequest {
    @NotNull(message = "The treatment id is required")
    private Long treatmentId; 
    @NotNull(message = "The medication id is required")
    private Long medicationId;

}
