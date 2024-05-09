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
        @NotBlank(message = "La fecha de inicio es requerida")
        private LocalDate startDate;
        @NotBlank(message = "La fecha de terminación es requerida")
        private LocalDate finalDate;
        @NotBlank(message = "La dosis de inicio con unidad de dispensación es requerida")
        private String dosage;
        @NotBlank(message = "La frecuencia es requerida")
        private LocalDateTime frecuency;
        @NotBlank(message = "El nombre del médico es requerido") 
        private String doctor; 
        @NotBlank(message = "El estado es requerido")
        private StateTreatment state; 
}
