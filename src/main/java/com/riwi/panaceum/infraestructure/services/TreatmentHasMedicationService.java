package com.riwi.panaceum.infraestructure.services;

import org.springframework.data.domain.Page;

import com.riwi.panaceum.api.dto.request.PatientRequest;
import com.riwi.panaceum.api.dto.request.TreatmentHasMedicationRequest;
import com.riwi.panaceum.api.dto.response.PatientResponse;
import com.riwi.panaceum.api.dto.response.TreatmentHasMedicationResponse;
import com.riwi.panaceum.infraestructure.abstract_services.ITreatmentHasMedicationService;

public class TreatmentHasMedicationService implements ITreatmentHasMedicationService {
    
    @Override
    public TreatmentHasMedicationResponse create(TreatmentHasMedicationRequest request){
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public TreatmentHasMedicationResponse get(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

     @Override
    public PatientResponse update(TreatmentHasMedicationRequest request, Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

      @Override
    public Page<TreatmentHasMedicationResponse> getAll(int page, int size) {
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}
