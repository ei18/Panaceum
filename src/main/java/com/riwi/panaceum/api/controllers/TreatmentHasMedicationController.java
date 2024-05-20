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

import com.riwi.panaceum.api.dto.request.TreatmentHasMedicationRequest;
import com.riwi.panaceum.api.dto.response.TreatmentHasMedicationResponse;
import com.riwi.panaceum.infraestructure.abstract_services.ITreatmentHasMedicationService;
import com.riwi.panaceum.utils.enums.SortType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/treatment-has-medications")
@AllArgsConstructor
@Tag(name = "Treatment has Medication")
public class TreatmentHasMedicationController {

    @Autowired
    private final ITreatmentHasMedicationService treatmentHasMedicationService;

    @Operation(
        summary = "List all treatments and medications with pagination",
        description = "You must submit the page and the page size to get all the corresponding treatments and medications"
    )
    @GetMapping
    public ResponseEntity<Page<TreatmentHasMedicationResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestHeader(required = false) SortType sortType
    ) {
        if (Objects.isNull(sortType)) {
            sortType = SortType.NONE;
        }

        return ResponseEntity.ok(this.treatmentHasMedicationService.getAll(page -1, size, sortType));
    }

    
    @ApiResponse(responseCode = "400", description = "When the id is invalid", content = {
    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    @Operation(
        summary = "List a treatment and medication by id",
        description = "You must send the id of the treatment and medication to search for"
    )  
    @GetMapping(path = "/{id}")
    public ResponseEntity<TreatmentHasMedicationResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.treatmentHasMedicationService.get(id));
    }

    
    @ApiResponse(responseCode = "400", description = "When the request is invalid", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @Operation(
        summary = "Create a treatment and medication",
        description = "Create a treatment and medication"
    )  
    @PostMapping
    public ResponseEntity<TreatmentHasMedicationResponse> insert(@Validated @RequestBody TreatmentHasMedicationRequest request) {
        return ResponseEntity.ok(this.treatmentHasMedicationService.create(request));
    }

    
    @ApiResponse(responseCode = "400", description = "When the request is invalid", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @Operation(
        summary = "Update a treatment and medication",
        description = "Update a treatment and medication"
    )  
    @PutMapping(path = "/{id}")
    public ResponseEntity<TreatmentHasMedicationResponse> update(@Validated @RequestBody TreatmentHasMedicationRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(this.treatmentHasMedicationService.update(request, id));
    }


    @ApiResponse(responseCode = "400", description = "When the id is invalid", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @Operation(
        summary = "Delete a treatment and medication by id",
        description = "Delete a treatment and medication by id"
    )  
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.treatmentHasMedicationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
