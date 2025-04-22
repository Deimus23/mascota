package itacademy.mascota.service;

import itacademy.mascota.model.Pet;
import itacademy.mascota.dto.PetDTO;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    public PetDTO convertToDTO(Pet pet) {
        return new PetDTO(
                pet.getId(),
                pet.getName(),
                pet.getPetColor(),
                pet.getPetType(),
                pet.getEnvironment(),
                pet.getComplement(),
                pet.getLife(),
                pet.getHappiness(),
                pet.getEnergy()
        );
    }

    public Pet convertToEntity(PetDTO petDTO) {
        Pet pet = new Pet();
        pet.setId(petDTO.getId());
        pet.setName(petDTO.getName());
        pet.setPetColor(petDTO.getPetColor());
        pet.setPetType(petDTO.getPetType());
        pet.setEnvironment(petDTO.getEnvironment());
        pet.setComplement(petDTO.getComplement());
        pet.setLife(petDTO.getLife());
        pet.setHappiness(petDTO.getHappiness());
        pet.setEnergy(petDTO.getEnergy());
        return pet;
    }
}
