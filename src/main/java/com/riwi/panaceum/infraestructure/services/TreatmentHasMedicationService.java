package com.riwi.panaceum.infraestructure.services;

import org.springframework.data.domain.Page;

import com.riwi.panaceum.api.dto.request.TreatmentHasMedicationRequest;
import com.riwi.panaceum.domain.repositories.TreatmentHasMedicationRepository;
import com.riwi.panaceum.infraestructure.abstract_services.ITreatmentHasMedicationService;
import com.riwi.panaceum.utils.enums.SortType;

public class TreatmentHasMedicationService implements ITreatmentHasMedicationService {

    @Override
    public TreatmentHasMedicationRepository create(TreatmentHasMedicationRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public TreatmentHasMedicationRepository get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public TreatmentHasMedicationRepository update(TreatmentHasMedicationRequest request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<TreatmentHasMedicationRepository> getAll(int page, int size, SortType sortType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
    
  

}
