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

import com.riwi.panaceum.api.dto.request.MedicationRequest;
import com.riwi.panaceum.api.dto.response.MedicationResponse;
import com.riwi.panaceum.infraestructure.abstract_services.IMedicationService;
import com.riwi.panaceum.utils.enums.SortType;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/medications")
@AllArgsConstructor
public class MedicationController {

    @Autowired
    private final IMedicationService medication;

    @GetMapping
    public ResponseEntity<Page<MedicationResponse>> getAll(@RequestParam(defaultValue = "1") int page,
    @RequestParam(defaultValue = "5") int size,
    @RequestHeader(required = false) SortType sortType){

        if (Objects.isNull(sortType)) {
            sortType = SortType.NONE;
        }

        return ResponseEntity.ok(this.medication.getAll(page - 1, size, sortType));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<MedicationResponse> get(@PathVariable Long id){
        return ResponseEntity.ok(this.medication.get(id));
    }

    @PostMapping
    public ResponseEntity<MedicationResponse> create(@Validated @RequestBody MedicationRequest request){
        return ResponseEntity.ok(this.medication.create(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<MedicationResponse> update(@Validated @RequestBody MedicationRequest request, @PathVariable Long id){
        return ResponseEntity.ok(this.medication.update(request, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.medication.delete(id);

        return ResponseEntity.noContent().build();
    }
}
