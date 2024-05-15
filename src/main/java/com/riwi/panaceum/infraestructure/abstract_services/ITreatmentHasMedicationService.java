package com.riwi.panaceum.infraestructure.abstract_services;

import com.riwi.panaceum.api.dto.request.TreatmentHasMedicationRequest;
import com.riwi.panaceum.api.dto.response.TreatmentHasMedicationResponse;

public interface ITreatmentHasMedicationService extends CrudService<TreatmentHasMedicationRequest, TreatmentHasMedicationResponse, Long>{
    public final String FIELD_BY_SORT = "id";
    
}
