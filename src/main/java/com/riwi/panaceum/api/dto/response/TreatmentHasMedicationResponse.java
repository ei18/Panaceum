package com.riwi.panaceum.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentHasMedicationResponse {
    private Long id;
    private Long treatmentId;
    private Long medicationId;
    private TreatmentResponse treatment;
    private MedicationResponse medication;
}
