package com.riwi.panaceum.infraestructure.abstract_services;

import com.riwi.panaceum.api.dto.request.MedicationRequest;
import com.riwi.panaceum.api.dto.response.MedicationResponse;

public interface IMedicationService extends CrudService<MedicationRequest, MedicationResponse, Long>{
    public final String FIELD_BY_SORT = "name";
}
