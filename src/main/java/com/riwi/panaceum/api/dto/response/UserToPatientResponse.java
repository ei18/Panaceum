package com.riwi.panaceum.api.dto.response;

import com.riwi.panaceum.utils.enums.RoleUser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserToPatientResponse {
    private Long id;
    private String email;
    private RoleUser role;
}
