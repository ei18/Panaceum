package com.riwi.panaceum.api.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentHasMedicationResponse {
    private Long treatmentsId;
    private Long medicationsId;
    private List<TreatmentResponse> treatments;
    private List<MedicationResponse> medications;
}
