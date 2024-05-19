package com.riwi.panaceum.infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riwi.panaceum.api.dto.request.MedicationRequest;
import com.riwi.panaceum.api.dto.response.MedicationResponse;
import com.riwi.panaceum.domain.entities.Medication;
import com.riwi.panaceum.domain.repositories.MedicationRepository;
import com.riwi.panaceum.infraestructure.abstract_services.IMedicationService;
import com.riwi.panaceum.utils.enums.SortType;
import com.riwi.panaceum.utils.messages.ErrorMessages;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class MedicationService implements IMedicationService {

    @Autowired
    private final MedicationRepository medicationRepository;
    
    @Override
    public MedicationResponse create(MedicationRequest request){
       Medication medication = this.requestToEntity(request);

       return this.entityToResponse(this.medicationRepository.save(medication));
    }
 
    @Override
    public MedicationResponse get(Long id){
        return this.entityToResponse(this.find(id));
    }

    @Override
    public MedicationResponse update(MedicationRequest request, Long id){
        Medication medication = this.find(id);

        medication = this.requestToEntity(request);
        medication.setId(id);

        return this.entityToResponse(this.medicationRepository.save(medication));
    }

    @Override
    public void delete(Long id){
       this.medicationRepository.delete(this.find(id));
    }

    @Override
    public Page<MedicationResponse> getAll(int page, int size, SortType sortType) {
        if (page < 0) page = 0;
      
      PageRequest pagination = null;

      switch (sortType) {
          case NONE -> pagination = PageRequest.of(page, size);
          case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
          case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
      }

      this.medicationRepository.findAll(pagination);

      return this.medicationRepository.findAll(pagination).map(this::entityToResponse);
    }

    private MedicationResponse entityToResponse(Medication entity){
        return MedicationResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .sideEffects(entity.getSideEffects())
                .activePrinciple(entity.getActivePrinciple())
                .build();
    }

    private Medication requestToEntity(MedicationRequest request){
        return Medication.builder()
                .name(request.getName())
                .sideEffects(request.getSideEffects())
                .activePrinciple(request.getActivePrinciple())
                .build();
    }
 
    private Medication find(Long id){
        return this.medicationRepository.findById(id).orElseThrow(() -> new com.riwi.panaceum.utils.exceptions.BadRequestException(ErrorMessages.idNotFound("Medication")));
    }
}

