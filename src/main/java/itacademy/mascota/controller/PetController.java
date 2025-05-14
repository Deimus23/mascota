package itacademy.mascota.controller;

import itacademy.mascota.dto.CreatePetDTO;
import itacademy.mascota.dto.PetDTO;
import itacademy.mascota.repository.PetRepository;
import itacademy.mascota.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<List<PetDTO>> getAllPets() {
        return ResponseEntity.ok(petService.getAllPets());
    }
    @GetMapping("/{id}")
    public ResponseEntity<PetDTO> getPetById(@PathVariable Long id) {
       return ResponseEntity.ok(this.petService.getPetById(id));
    }
    @GetMapping("/collection")
    public ResponseEntity<List<PetDTO>> getMyPets(){
        return ResponseEntity.ok(this.petService.getMyPets());
    }

    @PostMapping
    public ResponseEntity<PetDTO> createPet(@RequestBody CreatePetDTO pet) {
        return ResponseEntity.ok(this.petService.createPet(pet));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetDTO> updatePet(@PathVariable Long id, @RequestBody PetDTO petDetails) {
        return ResponseEntity.ok(this.petService.updatePet( id,petDetails));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        this.petService.deletePet(id);
        return ResponseEntity.noContent().build();
    }
}
