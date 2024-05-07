package com.riwi.panaceum.domain.entities;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "medications")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Medications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    @Column(length = 255, nullable = false)
    private String name; 
    @Column(length = 255, nullable = false)
    private String side_effects;
    @Column(length = 255, nullable = false)
    private String active_principle;

    @OneToMany(mappedBy = "medications", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<TreatmentsHasMedications> treatments_has_medications;
}
