package com.riwi.panaceum.infraestructure.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riwi.panaceum.api.dto.request.UserRequest;
import com.riwi.panaceum.api.dto.response.PatientToUserResponse;
import com.riwi.panaceum.api.dto.response.UserResponse;
import com.riwi.panaceum.domain.entities.Patient;
import com.riwi.panaceum.domain.entities.User;
import com.riwi.panaceum.domain.repositories.UserRepository;
import com.riwi.panaceum.infraestructure.abstract_services.IUserService;
import com.riwi.panaceum.utils.enums.GenderPatient;
import com.riwi.panaceum.utils.enums.SortType;
import com.riwi.panaceum.utils.enums.TypeBloodPatient;
import com.riwi.panaceum.utils.exceptions.BadRequestException;
import com.riwi.panaceum.utils.messages.ErrorMessages;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService{

    @Autowired
    private final UserRepository userRepository;

    @Override
    public UserResponse create(UserRequest request) {
        User user = this.requestToEntity(request);
        
        return this.entityToResponse(this.userRepository.save(user));
    }

    @Override
    public UserResponse get(Long id) {
       return this.entityToResponse(this.find(id));
    }

    @Override
    public UserResponse update(UserRequest request, Long id) {
        User user = this.find(id);

        user = this.requestToEntity(request);
        user.setId(id);

        return this.entityToResponse(this.userRepository.save(user));
    }

    @Override
    public void delete(Long id) {
        this.userRepository.delete(this.find(id));
    }

    @Override
    public Page<UserResponse> getAll(int page, int size, SortType sortType) {
        if (page < 0) page = 0;

        PageRequest pagination = null;

        switch (sortType){
          case NONE -> pagination = PageRequest.of(page, size);
          case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
          case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        this.userRepository.findAll(pagination);

        return this.userRepository.findAll(pagination).map(this::entityToResponse);
    }
    
    private UserResponse entityToResponse(User entity){
        List<PatientToUserResponse> patients = new ArrayList<>();
    
        return UserResponse.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .role(entity.getRole())
                .patients(patients)
                .build();
    }

    private User requestToEntity(UserRequest request){
        return User.builder()
                    .email(request.getEmail())
                    .password(request.getPassword())
                    .role(request.getRole())
                    .build();
    }

    private User find(Long id){
        return this.userRepository.findById(id).orElseThrow(() -> new BadRequestException(ErrorMessages.idNotFound("User")));
    }
}
