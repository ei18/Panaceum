package com.riwi.panaceum.domain.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.riwi.panaceum.utils.enums.StateTreatments;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

@Entity(name = "treatments")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Treatments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    @Column(length = 10, nullable = false)
    private LocalDate start_date;
    @Column(length = 10, nullable = false)
    private LocalDate final_date;
    @Column(length = 20, nullable = false)
    private String dosage;
    @Column(nullable = false) 
    private LocalDateTime frecuency; 
    @Column(length = 255, nullable = false)
    private String doctor; 
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StateTreatments state; 
    
    @OneToMany(mappedBy = "treatments", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<TreatmentsHasMedications> treatments_has_medications;
    
}
