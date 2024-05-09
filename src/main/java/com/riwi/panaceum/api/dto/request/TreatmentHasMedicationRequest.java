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
    @NotNull(message = "El id de tratamiento es obligatorio")
    private Long treatmentsId; 
    @NotNull(message = "El id de medicamentos es obligatorio")
    private Long medicationsId;

}
