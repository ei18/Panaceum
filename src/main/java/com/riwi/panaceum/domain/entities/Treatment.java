package com.riwi.panaceum.domain.entities;

import java.time.LocalDate;
import java.util.List;

import com.riwi.panaceum.utils.enums.StateTreatment;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "treatments")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    @Column(length = 10, nullable = false)
    private LocalDate startDate;
    @Column(length = 10, nullable = false)
    private LocalDate finalDate;
    @Column(length = 20, nullable = false)
    private String dosage;
    @Column(nullable = false) 
    private String frequency; 
    @Column(length = 255, nullable = false)
    private String doctor; 
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StateTreatment state; 
    
    @OneToMany(mappedBy = "treatment", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<TreatmentHasMedication> treatmentsHasMedications;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patients_id", referencedColumnName = "id")
    private Patient patient;
    
}
