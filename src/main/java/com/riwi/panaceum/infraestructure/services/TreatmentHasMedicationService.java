package com.riwi.panaceum.infraestructure.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.panaceum.api.dto.request.TreatmentHasMedicationRequest;
import com.riwi.panaceum.api.dto.response.MedicationResponse;
import com.riwi.panaceum.api.dto.response.TreatmentHasMedicationResponse;
import com.riwi.panaceum.api.dto.response.TreatmentResponse;
import com.riwi.panaceum.domain.entities.Medication;
import com.riwi.panaceum.domain.entities.Treatment;
import com.riwi.panaceum.domain.entities.TreatmentHasMedication;
import com.riwi.panaceum.domain.repositories.MedicationRepository;
import com.riwi.panaceum.domain.repositories.TreatmentHasMedicationRepository;
import com.riwi.panaceum.domain.repositories.TreatmentRepository;
import com.riwi.panaceum.infraestructure.abstract_services.ITreatmentHasMedicationService;
import com.riwi.panaceum.utils.enums.SortType;
import com.riwi.panaceum.utils.exceptions.BadRequestException;
import com.riwi.panaceum.utils.messages.ErrorMessages;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class TreatmentHasMedicationService implements ITreatmentHasMedicationService {

    @Autowired
    private final TreatmentHasMedicationRepository treatmentHasMedicationRepository;

    @Autowired
    private final TreatmentRepository treatmentRepository;

    @Autowired
    private final MedicationRepository medicationRepository;

    @Override
    public TreatmentHasMedicationResponse create(TreatmentHasMedicationRequest request) {
        

        Treatment treatment = this.treatmentRepository.findById(request.getTreatmentId()).orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("Treatment")));

        Medication medication = this.medicationRepository.findById(request.getMedicationId()).orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("Medication")));

        TreatmentHasMedication treatmentHasMedication = this.requestToEntity(request);

        treatmentHasMedication.setTreatment(treatment);
        treatmentHasMedication.setMedication(medication);

        return this.entityToResponse(this.treatmentHasMedicationRepository.save(treatmentHasMedication));
    }

    @Override
    public TreatmentHasMedicationResponse get(Long id) {
        return this.entityToResponse(this.find(id));
    }

    @Override
    public TreatmentHasMedicationResponse update(TreatmentHasMedicationRequest request, Long id) {

        TreatmentHasMedication treatmentHasMedication = this.find(id);

       Treatment treatment = this.treatmentRepository.findById(request.getTreatmentId()).orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("treatment")));

       Medication medication = this.medicationRepository.findById(request.getMedicationId()).orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("medication")));

        treatmentHasMedication = this.requestToEntity(request);

        treatmentHasMedication.setTreatment(treatment);
        treatmentHasMedication.setMedication(medication);
        treatmentHasMedication.setId(id);

        return this.entityToResponse(this.treatmentHasMedicationRepository.save(treatmentHasMedication));
    }

    @Override
    public void delete(Long id) {
        this.treatmentHasMedicationRepository.delete(this.find(id));
    }

    @Override
    public Page<TreatmentHasMedicationResponse> getAll(int page, int size, SortType sortType) {
        if(page < 0)
        page = 0;

        PageRequest pagination = null;

        switch (sortType){
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        return this.treatmentHasMedicationRepository.findAll(pagination).map(this::entityToResponse);
    }
    
       private TreatmentHasMedicationResponse entityToResponse(TreatmentHasMedication entity){

        MedicationResponse medication = new MedicationResponse();
        BeanUtils.copyProperties(entity.getMedication(), medication);

        TreatmentResponse treatment = new TreatmentResponse();
        BeanUtils.copyProperties(entity.getTreatment(), treatment);

        return TreatmentHasMedicationResponse.builder()
                .id(entity.getId())
                .treatmentId(entity.getTreatmentId())
                .medicationId(entity.getMedicationId())
                .treatment(treatment)
                .medication(medication)
                .build();

    } 

    private TreatmentHasMedication requestToEntity(TreatmentHasMedicationRequest request){
        return TreatmentHasMedication.builder()
                .treatmentId(request.getTreatmentId())
                .medicationId(request.getMedicationId())
                .build();
    }
    
    private TreatmentHasMedication find(Long id){
        return this.treatmentHasMedicationRepository.findById(id).orElseThrow(() -> new com.riwi.panaceum.utils.exceptions.BadRequestException(ErrorMessages.idNotFound("TreatmentHasMedication")));
    }
    
}