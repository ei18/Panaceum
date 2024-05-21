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

import com.riwi.panaceum.api.dto.request.TreatmentRequest;
import com.riwi.panaceum.api.dto.response.TreatmentResponse;
import com.riwi.panaceum.infraestructure.abstract_services.ITreatmentService;
import com.riwi.panaceum.utils.enums.SortType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/treatments")
@AllArgsConstructor
@Tag(name = "Treatments")
public class TreatmentController {
    
    @Autowired
    private final ITreatmentService treatmentService;

    @Operation(
        summary = "List all treatments with pagination",
        description = "You must submit the page and the page size to get all the corresponding treatments"
    )
    @GetMapping
    public ResponseEntity<Page<TreatmentResponse>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestHeader(required = false) SortType sortType
    ){
        if (Objects.isNull(sortType)) {
            sortType = SortType.NONE;
        }

        return ResponseEntity.ok(this.treatmentService.getAll(page -1, size, sortType));
    }


    @ApiResponse(responseCode = "400", description = "When the id is invalid", content = {
    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    @Operation(
        summary = "List a treatment by id",
        description = "You must send the id of the treatment to search for"
    )  
    @GetMapping(path = "/{id}")
    public ResponseEntity<TreatmentResponse> get(@PathVariable Long id){
        return ResponseEntity.ok(this.treatmentService.get(id));
    }


    @ApiResponse(responseCode = "400", description = "When the request is invalid", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @Operation(
        summary = "Create a treatment",
        description = "Create a treatment"
    )  
    @PostMapping
    public ResponseEntity<TreatmentResponse> insert(@Validated @RequestBody TreatmentRequest request){
        return ResponseEntity.ok(this.treatmentService.create(request));
    }


    @ApiResponse(responseCode = "400", description = "When the request is invalid", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @Operation(
        summary = "Update a treatment",
        description = "Update a treatment"
    )  
    @PutMapping(path = "/{id}")
    public ResponseEntity<TreatmentResponse> update(@Validated @RequestBody TreatmentRequest request, @PathVariable Long id){
        return ResponseEntity.ok(this.treatmentService.update(request, id));
    }

    
    @ApiResponse(responseCode = "400", description = "When the id is invalid", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @Operation(
        summary = "Delete a treatment by id",
        description = "Delete a treatment by id"
    )  
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.treatmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
