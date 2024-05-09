package com.riwi.panaceum.api.dto.request;

import com.riwi.panaceum.utils.enums.RoleUser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @Email(message = "The email is invalid")
    @Size(min = 5, max = 100, message = "The email must be between 5 and 100 characters")
    private String email;
    @NotBlank(message = "The password is required")
    @Size(min = 5, max = 45, message = "The password must contain between 5 and 45 characters")
    private String password;
    @NotBlank(message = "The role is required")
    private RoleUser role;
}
