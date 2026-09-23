package com.pawhome.service;

import com.pawhome.dto.AdoptionRequestDto;
import com.pawhome.model.AdoptionRequest;
import com.pawhome.model.Animal;
import com.pawhome.repository.AdoptionRequestRepository;
import com.pawhome.repository.AnimalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdoptionService {

    private final AdoptionRequestRepository adoptionRequestRepository;
    private final AnimalRepository animalRepository;

    public AdoptionService(AdoptionRequestRepository adoptionRequestRepository,
                           AnimalRepository animalRepository) {
        this.adoptionRequestRepository = adoptionRequestRepository;
        this.animalRepository = animalRepository;
    }

    @Transactional
    public AdoptionRequest submitRequest(AdoptionRequestDto dto) {
        Animal animal = animalRepository.findById(dto.getAnimalId())
                .orElseThrow(() -> new IllegalArgumentException("Animal not found"));

        if (!animal.isAvailable()) {
            throw new IllegalStateException("This animal is no longer available for adoption");
        }

        AdoptionRequest request = new AdoptionRequest();
        request.setAnimal(animal);
        request.setAdopterName(dto.getAdopterName());
        request.setEmail(dto.getEmail());
        request.setPhone(dto.getPhone());
        request.setAddress(dto.getAddress());
        request.setMessage(dto.getMessage());

        return adoptionRequestRepository.save(request);
    }

    public List<AdoptionRequest> getAllRequests() {
        return adoptionRequestRepository.findAll();
    }
}
