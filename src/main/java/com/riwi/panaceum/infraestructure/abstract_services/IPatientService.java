package com.riwi.panaceum.infraestructure.abstract_services;

import com.riwi.panaceum.api.dto.request.PatientRequest;
import com.riwi.panaceum.api.dto.response.PatientResponse;

public interface IPatientService extends CrudService<PatientRequest, PatientResponse, String>{
    public final String FIELD_BY_SORT = "name";
}
