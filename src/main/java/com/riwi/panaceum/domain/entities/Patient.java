package com.riwi.panaceum.domain.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "patients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 40, nullable = false)
    private String document_type;

    @Column(nullable = false)
    private Integer document_number;

    @Column(nullable = false)
    private LocalDate date_birth;

    @Column(length = 15, nullable = false)
    private String gender;

    @Column(length = 15, nullable = false)
    private String rh;

    @Column(length = 255, nullable = false)
    private String diagnostic;

    @Column(length = 40, nullable = false)
    private String email;

    @Column(length = 15, nullable = false)
    private String password;

    @Column(nullable = false)
    private String photo;
}
