package com.pawhome.service;

import com.pawhome.model.Animal;
import com.pawhome.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAllAvailable() {
        return animalRepository.findByAvailableTrue();
    }

    public List<Animal> getBySpecies(String species) {
        if (species == null || species.isBlank() || species.equalsIgnoreCase("all")) {
            return getAllAvailable();
        }
        return animalRepository.findBySpeciesIgnoreCaseAndAvailableTrue(species);
    }

    public Optional<Animal> getById(Long id) {
        return animalRepository.findById(id);
    }
}
