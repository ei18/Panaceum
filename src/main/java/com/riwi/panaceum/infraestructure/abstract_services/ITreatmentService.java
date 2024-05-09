package com.riwi.panaceum.infraestructure.abstract_services;

import com.riwi.panaceum.api.dto.request.TreatmentRequest;
import com.riwi.panaceum.domain.repositories.TreatmentRepository;

public interface ITreatmentService extends CrudService<TreatmentRequest, TreatmentRepository, Long>{
    public String FIELD_BY_SORT = "startDate";
    
}
