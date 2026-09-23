package com.pawhome.config;

import com.pawhome.model.Animal;
import com.pawhome.repository.AnimalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final AnimalRepository animalRepository;

    public DataSeeder(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public void run(String... args) {
        seedAnimal("Bruno", "Dog", "Labrador", 3, "Male", "Large",
                "Friendly and energetic. Loves playing fetch and long walks.",
                "https://images.unsplash.com/photo-1587300003388-59208cc962cb?w=600", true);

        seedAnimal("Luna", "Cat", "Persian", 2, "Female", "Small",
                "Calm and affectionate. Enjoys sunny windowsills and gentle cuddles.",
                "https://images.unsplash.com/photo-1514888286974-6c03e2ca1dba?w=600", true);

        seedAnimal("Max", "Dog", "Beagle", 4, "Male", "Medium",
                "Curious nose and a big heart. Great with kids and other pets.",
                "https://images.unsplash.com/photo-1543466835-00a7907e9de1?w=600", true);

        seedAnimal("Milo", "Cat", "Siamese", 1, "Male", "Small",
                "Playful kitten who loves toys and climbing. Very social.",
                "https://images.unsplash.com/photo-1574158622682-e40e69881006?w=600", true);

        seedAnimal("Bella", "Dog", "Golden Retriever", 5, "Female", "Large",
                "Gentle giant with a golden smile. Perfect family companion.",
                "https://images.unsplash.com/photo-1633722715463-d30f4f325e24?w=600", true);

        seedAnimal("Coco", "Rabbit", "Holland Lop", 1, "Female", "Small",
                "Soft fur and quiet personality. Ideal for apartment living.",
                "https://images.unsplash.com/photo-1585110397769-c9ffdfe65ea2?w=600", true);

        seedAnimal("Rocky", "Dog", "German Shepherd", 2, "Male", "Large",
                "Loyal and intelligent. Needs an active owner who enjoys training.",
                "https://images.unsplash.com/photo-1568640347023-a616a30bc3bd?w=600", true);

        seedAnimal("Whiskers", "Cat", "Tabby", 3, "Female", "Medium",
                "Independent but loving. Enjoys both playtime and quiet naps.",
                "https://images.unsplash.com/photo-1495360010541-f48722b34f7d?w=600", true);
    }

    private void seedAnimal(String name, String species, String breed, int age,
                            String gender, String size, String description,
                            String imageUrl, boolean vaccinated) {
        Animal animal = new Animal();
        animal.setName(name);
        animal.setSpecies(species);
        animal.setBreed(breed);
        animal.setAge(age);
        animal.setGender(gender);
        animal.setSize(size);
        animal.setDescription(description);
        animal.setImageUrl(imageUrl);
        animal.setVaccinated(vaccinated);
        animal.setAvailable(true);
        animalRepository.save(animal);
    }
}
