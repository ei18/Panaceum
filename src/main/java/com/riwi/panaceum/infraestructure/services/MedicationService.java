package com.riwi.panaceum.infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.riwi.panaceum.api.dto.request.MedicationRequest;
import com.riwi.panaceum.api.dto.response.MedicationResponse;
import com.riwi.panaceum.domain.repositories.MedicationRepository;
import com.riwi.panaceum.infraestructure.abstract_services.IMedicationService;

public class MedicationService implements IMedicationService {
    
    @Override
    public MedicationResponse create(MedicationRequest request){
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }
 
    @Override
    public MedicationResponse get(Long id){
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public MedicationResponse update(MedicationRequest request, Long id){
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id){
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<MedicationResponse> getAll(int page, int size){
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
 
}
