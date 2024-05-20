package com.riwi.panaceum.domain.entities;

import java.time.LocalDate;
import java.util.List;

import com.riwi.panaceum.utils.enums.GenderPatient;
import com.riwi.panaceum.utils.enums.TypeBloodPatient;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "patients")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 255, nullable = false)
    private String name;
    @Column(length = 45, nullable = false)
    private String documentType;
    @Column(nullable = false)
    private double documentNumber;
    @Column(nullable = false)
    private LocalDate dateBirth;
    @Enumerated(EnumType.STRING)
    private GenderPatient gender;
    @Column(length = 45, nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeBloodPatient typeBlood;
    @Column(nullable = false)
    private String diagnostic;
    @Column(length = 100, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String photo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Treatment> treatments;

}
