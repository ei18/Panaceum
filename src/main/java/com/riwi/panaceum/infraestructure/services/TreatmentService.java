package com.riwi.panaceum.infraestructure.services;

import org.springframework.data.domain.Page;

import com.riwi.panaceum.api.dto.request.TreatmentRequest;
import com.riwi.panaceum.domain.repositories.TreatmentRepository;
import com.riwi.panaceum.infraestructure.abstract_services.ITreatmentService;
import com.riwi.panaceum.utils.enums.SortType;

public class TreatmentService implements ITreatmentService{

    @Override
    public TreatmentRepository create(TreatmentRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public TreatmentRepository get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public TreatmentRepository update(TreatmentRequest request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<TreatmentRepository> getAll(int page, int size, SortType sortType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
      
}
