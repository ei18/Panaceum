package com.riwi.panaceum.infraestructure.services;

import org.springframework.data.domain.Page;

import com.riwi.panaceum.api.dto.request.PatientRequest;
import com.riwi.panaceum.api.dto.request.TreatmentRequest;
import com.riwi.panaceum.api.dto.response.MedicationResponse;
import com.riwi.panaceum.api.dto.response.PatientResponse;
import com.riwi.panaceum.api.dto.response.TreatmentResponse;
import com.riwi.panaceum.infraestructure.abstract_services.ITreatmentService;

public class TreatmentService implements ITreatmentService{
    
    @Override
    public TreatmentResponse create(TreatmentRequest request){
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public TreatmentResponse get(Long id){
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

     @Override
    public TreatmentResponse update(TreatmentRequest request, Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

     @Override
    public Page<TreatmentResponse> getAll(int page, int size) {
          throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
}
