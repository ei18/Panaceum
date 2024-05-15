package com.riwi.panaceum.api.controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/treatments")
@AllArgsConstructor
public class TreatmentController {
    
    @Autowired
    private final ITreatmentService treatmentService;

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

    @GetMapping(path = "/{id}")
    public ResponseEntity<TreatmentResponse> get(@PathVariable Long id){
        return ResponseEntity.ok(this.treatmentService.get(id));
    }

    @PostMapping
    public ResponseEntity<TreatmentResponse> insert(@Validated @RequestBody TreatmentRequest request){
        return ResponseEntity.ok(this.treatmentService.create(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<TreatmentResponse> update(@Validated @RequestBody TreatmentRequest request, @PathVariable Long id){
        return ResponseEntity.ok(this.treatmentService.update(request, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.treatmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
