package com.riwi.panaceum.api.controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.panaceum.api.dto.request.PatientRequest;
import com.riwi.panaceum.api.dto.response.PatientResponse;
import com.riwi.panaceum.infraestructure.abstract_services.IPatientService;
import com.riwi.panaceum.utils.enums.SortType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/patients")
@AllArgsConstructor
@Tag(name = "Patients")
public class PatientController {
    @Autowired
    private final IPatientService patientService;

    @Operation(
        summary = "List all patients with pagination",
        description = "You must submit the page and the page size to get all the corresponding patients"
    )
    @GetMapping
    public ResponseEntity<Page<PatientResponse>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestHeader(required = false) SortType sortType
    ){
        if (Objects.isNull(sortType))
            sortType = SortType.NONE;

        return ResponseEntity.ok(this.patientService.getAll(page - 1, size, sortType));
    }


    @ApiResponse(responseCode = "400", description = "When the id is invalid", content = {
    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    @Operation(
        summary = "List a patient by id",
        description = "You must send the id of the patient to search for"
    )   
    @GetMapping(path = "/{id}")
    public ResponseEntity<PatientResponse> get(@PathVariable String id){
        return ResponseEntity.ok(this.patientService.get(id));
    }

    
    @ApiResponse(responseCode = "400", description = "When the request is invalid", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    
    @Operation(
        summary = "Create a patient",
        description = "Create a patient"
    )  
    @PostMapping
    public ResponseEntity<PatientResponse> insert(@Validated @RequestBody PatientRequest request){
        return ResponseEntity.ok(this.patientService.create(request));
    }


    @ApiResponse(responseCode = "400", description = "When the request is invalid", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @Operation(
        summary = "Update a patient",
        description = "Update a patient"
    )  
    @PutMapping(path = "/{id}")
    public ResponseEntity<PatientResponse> update(@Validated @RequestBody PatientRequest request, @PathVariable String id){
        return ResponseEntity.ok(this.patientService.update(request, id));
    }


    @ApiResponse(responseCode = "400", description = "When the id is invalid", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @Operation(
        summary = "Delete a patient by id",
        description = "Delete a patient by id"
    )  
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.patientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}