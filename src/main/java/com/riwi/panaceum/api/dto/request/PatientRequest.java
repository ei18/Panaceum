package com.riwi.panaceum.api.dto.request;

import java.time.LocalDate;

import com.riwi.panaceum.utils.enums.GenderPatient;
import com.riwi.panaceum.utils.enums.TypeBloodPatient;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequest {
    @NotBlank(message = "The name is required")
    private String name;
    @NotBlank(message = "The type of document is required")
    private String documentType;
    @NotNull(message = "The document number is required")
    private String documentNumber;
    @NotNull(message = "The date of birth is required")
    private LocalDate dateBirth;
    private GenderPatient gender;
    @NotNull(message = "The blood type is required.")
    private TypeBloodPatient typeBlood;
    @NotBlank(message = "The diagnostic is required")
    private String diagnostic;
    @Email(message = "The email is invalid")
    @Size(min = 5, max = 100, message = "The email must be between 5 and 100 characters")
    private String email;
    @NotBlank(message = "The password is required")
    @Size(min = 5, max = 45, message = "The password must contain between 5 and 45 characters")
    private String password;
    private String photo;
    private Long usersId;
}
