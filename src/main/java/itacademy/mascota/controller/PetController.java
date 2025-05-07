package itacademy.mascota.controller;

import itacademy.mascota.model.Pet;
import itacademy.mascota.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        return ResponseEntity.ok(petRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
        Optional<Pet> pet = petRepository.findById(id);
        return pet.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {

        if (pet.getLife() == 0) pet.setLife(100);
        if (pet.getHappiness() == 0) pet.setHappiness(100);
        if (pet.getEnergy() == 0) pet.setEnergy(100);

        Pet savedPet = petRepository.save(pet);
        return ResponseEntity.ok(savedPet);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long id, @RequestBody Pet petDetails) {
        return petRepository.findById(id)
                .map(pet -> {
                    pet.setName(petDetails.getName());
                    pet.setPetColor(petDetails.getPetColor());
                    pet.setPetType(petDetails.getPetType());
                    pet.setEnvironment(petDetails.getEnvironment());
                    pet.setComplement(petDetails.getComplement());
                    pet.setLife(petDetails.getLife());
                    pet.setHappiness(petDetails.getHappiness());
                    pet.setEnergy(petDetails.getEnergy());

                    return ResponseEntity.ok(petRepository.save(pet));
                })
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        return petRepository.findById(id)
                .map(pet -> {
                    petRepository.delete(pet);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
