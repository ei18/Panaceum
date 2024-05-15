package com.riwi.panaceum.infraestructure.abstract_services;

import com.riwi.panaceum.api.dto.request.TreatmentRequest;
import com.riwi.panaceum.api.dto.response.TreatmentResponse;

public interface ITreatmentService extends CrudService<TreatmentRequest, TreatmentResponse, Long>{
    public final String FIELD_BY_SORT = "startDate";
    
}
