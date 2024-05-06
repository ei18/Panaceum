package com.riwi.panaceum.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "medications")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Medications {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id; 
    @Column(length = 255, nullable = false)
    private String name; 
    @Column(length = 255, nullable = false)
    private String side_effects;
    @Column(length = 255, nullable = false)
    private String active_principle;
}
