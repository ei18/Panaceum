package com.riwi.panaceum.infraestructure.abstract_services;

import com.riwi.panaceum.api.dto.request.TreatmentHasMedicationRequest;
import com.riwi.panaceum.domain.repositories.TreatmentHasMedicationRepository;

public interface ITreatmentHasMedicationService extends CrudService<TreatmentHasMedicationRequest, TreatmentHasMedicationRepository, Long>{
    public String FIELD_BY_SORT = "id";
    
}
