package com.riwi.panaceum.infraestructure.services;

import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.panaceum.api.dto.request.TreatmentRequest;
import com.riwi.panaceum.api.dto.response.PatientResponse;
import com.riwi.panaceum.api.dto.response.TreatmentResponse;
import com.riwi.panaceum.domain.entities.Patient;
import com.riwi.panaceum.domain.entities.Treatment;
import com.riwi.panaceum.domain.repositories.PatientRepository;
import com.riwi.panaceum.domain.repositories.TreatmentRepository;
import com.riwi.panaceum.infraestructure.abstract_services.ITreatmentService;
import com.riwi.panaceum.infraestructure.helpers.EmailHelper;
import com.riwi.panaceum.utils.enums.SortType;
import com.riwi.panaceum.utils.exceptions.BadRequestException;
import com.riwi.panaceum.utils.exceptions.IdNotFoundException;
import com.riwi.panaceum.utils.messages.ErrorMessages;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class TreatmentService implements ITreatmentService{


    @Autowired
    private final TreatmentRepository treatmentRepository;

    @Autowired
    private final PatientRepository patientRepository;

    @Autowired
    private final EmailHelper emailHelper;

    @Override
    public TreatmentResponse create(TreatmentRequest request) {
        Patient patient = this.patientRepository.findById(request.getPatientId())
            .orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("patient")));
    
          Treatment treatment = this.requestToEntity(request);
    
          treatment.setPatient(patient);

            if (Objects.nonNull(patient.getEmail())) {
            this.emailHelper.sendMail(patient.getEmail(), patient.getName(), patient.getDiagnostic(), treatment.getFrequency());
        }
        
          return this.entityToResponse(this.treatmentRepository.save(treatment));
        }


    @Override
    public TreatmentResponse get(Long id) {
        return this.entityToResponse(this.find(id));
    }

    @Override
    public TreatmentResponse update(TreatmentRequest request, Long id) {
        
        Treatment treatment = this.find(id);

        Patient patient = this.patientRepository.findById(request.getPatientId())
        .orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("patient")));

        treatment = this.requestToEntity(request);

        treatment.setPatient(patient);
        treatment.setId(id);

        return this.entityToResponse(this.treatmentRepository.save(treatment));
    }

    @Override
    public void delete(Long id) {

        this.treatmentRepository.delete(this.find(id));
    }

    @Override
    public Page<TreatmentResponse> getAll(int page, int size, SortType sortType) {
        if(page < 0)
        page = 0;

        PageRequest pagination = null; 

        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        return this.treatmentRepository.findAll(pagination)
                .map(this::entityToResponse);
                
    }


    private TreatmentResponse entityToResponse(Treatment entity){

        PatientResponse patient = new PatientResponse();
        BeanUtils.copyProperties(entity.getPatient(), patient);
                return TreatmentResponse.builder()
                        .id(entity.getId())
                        .startDate(entity.getStartDate())
                        .finalDate(entity.getFinalDate())
                        .dosage(entity.getDosage())
                        .frequency(entity.getFrequency())
                        .doctor(entity.getDoctor())
                        .state(entity.getState())
                        .patient(patient)
                        .build();
    }
      
    private Treatment requestToEntity(TreatmentRequest request){
                return Treatment.builder()
                        .startDate(request.getStartDate())
                        .finalDate(request.getFinalDate())
                        .dosage(request.getDosage())
                        .frequency(request.getFrequency())
                        .doctor(request.getDoctor())
                        .state(request.getState())
                        .build();
            } 
          
    private Treatment find(Long id){
            return this.treatmentRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Treatment"));
            }
}
