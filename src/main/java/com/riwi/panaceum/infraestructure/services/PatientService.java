package com.riwi.panaceum.infraestructure.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.panaceum.api.dto.request.PatientRequest;
import com.riwi.panaceum.api.dto.response.PatientResponse;
import com.riwi.panaceum.api.dto.response.UserToPatientResponse;
import com.riwi.panaceum.domain.entities.Patient;
import com.riwi.panaceum.domain.entities.User;
import com.riwi.panaceum.domain.repositories.PatientRepository;
import com.riwi.panaceum.domain.repositories.UserRepository;
import com.riwi.panaceum.infraestructure.abstract_services.IPatientService;
import com.riwi.panaceum.utils.enums.SortType;
import com.riwi.panaceum.utils.exceptions.BadRequestException;
import com.riwi.panaceum.utils.messages.ErrorMessages;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class PatientService implements IPatientService{

    @Autowired
    private final PatientRepository patientRepository;

    @Autowired
    private final UserRepository userRepository;

    @Override
    public PatientResponse create(PatientRequest request) {

        User user = this.userRepository.findById(request.getUsersId()).orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("user")));

        Patient patient = this.requestToEntity(request);

        patient.setUser(user);

        return this.entityToResponse(this.patientRepository.save(patient));
    }

    @Override
    public PatientResponse get(String id) {
        return this.entityToResponse(this.find(id));
    }

    @Override
    public PatientResponse update(PatientRequest request, String id) {
       Patient patient = this.find(id);

       User user = this.userRepository.findById(request.getUsersId()).orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("user")));

       patient = this.requestToEntity(request);

       patient.setUser(user);
       patient.setId(id);

       return this.entityToResponse(this.patientRepository.save(patient));
    }

    @Override
    public void delete(String id) {
        this.patientRepository.delete(this.find(id));
    }

    @Override
    public Page<PatientResponse> getAll(int page, int size, SortType sortType) {
        if (page < 0)
            page = 0;

        PageRequest pagination = null;

        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        return this.patientRepository.findAll(pagination)
                .map(this::entityToResponse);
    }

    
    private PatientResponse entityToResponse(Patient entity){
        UserToPatientResponse user = new UserToPatientResponse();
        BeanUtils.copyProperties(entity.getUser(), user);

        return PatientResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .documentType(entity.getDocumentType())
                .documentNumber(entity.getDocumentNumber())
                .dateBirth(entity.getDateBirth())
                .gender(entity.getGender())
                .typeBlood(entity.getTypeBlood())
                .diagnostic(entity.getDiagnostic())
                .email(entity.getEmail())
                .photo(entity.getPhoto())
                .user(user)
                .build();

    } 

    private Patient requestToEntity(PatientRequest request){
        return Patient.builder()
                .name(request.getName())
                .documentType(request.getDocumentType())
                .documentNumber(request.getDocumentNumber())
                .dateBirth(request.getDateBirth())
                .gender(request.getGender())
                .typeBlood(request.getTypeBlood())
                .diagnostic(request.getDiagnostic())
                .email(request.getEmail())
                .password(request.getPassword())
                .photo(request.getPhoto())
                .build();
    }
    
    private Patient find(String id){
        return this.patientRepository.findById(id).orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("Patient")));

    }

}

