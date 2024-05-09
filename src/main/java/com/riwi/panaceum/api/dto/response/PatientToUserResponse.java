package com.riwi.panaceum.api.dto.response;

import java.time.LocalDate;

import com.riwi.panaceum.utils.enums.GenderPatient;
import com.riwi.panaceum.utils.enums.TypeBloodPatient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientToUserResponse {
    private String id;
    private String name;    
    private String documentType;    
    private double documentNumber;    
    private LocalDate dateBirth;    
    private GenderPatient gender;
    private TypeBloodPatient typeBlood;    
    private String diagnostic;    
    private String email;
    private String photo;
}
