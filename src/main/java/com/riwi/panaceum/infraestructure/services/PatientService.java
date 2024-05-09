package com.riwi.panaceum.infraestructure.services;

import org.springframework.data.domain.Page;

import com.riwi.panaceum.api.dto.request.PatientRequest;
import com.riwi.panaceum.api.dto.response.PatientResponse;
import com.riwi.panaceum.infraestructure.abstract_services.IPatientService;

public class PatientService implements IPatientService{

    @Override
    public PatientResponse create(PatientRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public PatientResponse get(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public PatientResponse update(PatientRequest request, String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<PatientResponse> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
    
}
