package com.riwi.panaceum.api.dto.request;

import java.time.LocalDate;

import com.riwi.panaceum.utils.enums.StateTreatment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentRequest {
        @NotNull(message = "The start date is required")
        private LocalDate startDate;
        @NotNull(message = "The final date is required")
        private LocalDate finalDate;
        @NotBlank(message = "The dosage is required")
        private String dosage;
        @NotBlank(message = "The frequency is required")
        private String frequency;
        @NotBlank(message = "The doctor's name is required") 
        private String doctor; 
        @NotNull(message = "The state is required")
        private StateTreatment state; 
        private String PatientId;
        
}
