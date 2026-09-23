package com.pawhome.controller;

import com.pawhome.dto.AdoptionRequestDto;
import com.pawhome.model.AdoptionRequest;
import com.pawhome.service.AdoptionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/adoptions")
public class AdoptionController {

    private final AdoptionService adoptionService;

    public AdoptionController(AdoptionService adoptionService) {
        this.adoptionService = adoptionService;
    }

    @PostMapping
    public ResponseEntity<?> submitAdoption(@Valid @RequestBody AdoptionRequestDto dto) {
        try {
            AdoptionRequest saved = adoptionService.submitRequest(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping
    public List<AdoptionRequest> getAllAdoptions() {
        return adoptionService.getAllRequests();
    }
}
