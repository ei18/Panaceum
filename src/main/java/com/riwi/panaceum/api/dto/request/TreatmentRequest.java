package com.riwi.panaceum.api.dto.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.riwi.panaceum.utils.enums.StateTreatment;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentRequest {
        @NotBlank(message = "The start date is required")
        private LocalDate startDate;
        @NotBlank(message = "The final date is required")
        private LocalDate finalDate;
        @NotBlank(message = "The dosage is required")
        private String dosage;
        @NotBlank(message = "The frequency is required")
        private LocalDateTime frequency;
        @NotBlank(message = "The doctor's name is required") 
        private String doctor; 
        @NotBlank(message = "The state is required")
        private StateTreatment state; 
}
