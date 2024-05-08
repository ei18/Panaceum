package com.riwi.panaceum.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "treatments_has_medications")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentHasMedication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "treatments_id", referencedColumnName = "id")
    private Treatment treatments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medications_id", referencedColumnName = "id")
    private Medication medications;
}
