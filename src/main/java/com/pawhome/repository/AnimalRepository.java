package com.pawhome.repository;

import com.pawhome.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByAvailableTrue();
    List<Animal> findBySpeciesIgnoreCaseAndAvailableTrue(String species);
}
