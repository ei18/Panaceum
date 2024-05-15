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

import com.riwi.panaceum.api.dto.request.TreatmentHasMedicationRequest;
import com.riwi.panaceum.api.dto.response.TreatmentHasMedicationResponse;
import com.riwi.panaceum.infraestructure.abstract_services.ITreatmentHasMedicationService;
import com.riwi.panaceum.utils.enums.SortType;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/treatment-has-medications")
@AllArgsConstructor
public class TreatmentHasMedicationController {

    @Autowired
    private final ITreatmentHasMedicationService treatmentHasMedicationService;

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

    @GetMapping(path = "/{id}")
    public ResponseEntity<TreatmentHasMedicationResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.treatmentHasMedicationService.get(id));
    }

    @PostMapping
    public ResponseEntity<TreatmentHasMedicationResponse> insert(@Validated @RequestBody TreatmentHasMedicationRequest request) {
        return ResponseEntity.ok(this.treatmentHasMedicationService.create(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<TreatmentHasMedicationResponse> update(@Validated @RequestBody TreatmentHasMedicationRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(this.treatmentHasMedicationService.update(request, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.treatmentHasMedicationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
