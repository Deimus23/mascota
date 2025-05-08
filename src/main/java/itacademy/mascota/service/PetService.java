package itacademy.mascota.service;

import itacademy.mascota.dto.PetDTO;
import itacademy.mascota.model.Pet;
import itacademy.mascota.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

    @Service
    public class PetService {

        @Autowired
        private PetRepository petRepository;

        public List<PetDTO> getAllPets() {
            return petRepository.findAll().stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        }

        public Optional<PetDTO> getPetById(Long id) {
            return petRepository.findById(id)
                    .map(this::convertToDTO);
        }

        public PetDTO createPet(PetDTO petDTO) {
            Pet pet = convertToEntity(petDTO);
            initializeDefaults(pet);
            Pet saved = petRepository.save(pet);
            return convertToDTO(saved);
        }

        public Optional<PetDTO> updatePet(Long id, PetDTO petDTO) {
            return petRepository.findById(id)
                    .map(existingPet -> {
                        updateEntityFromDTO(petDTO, existingPet);
                        Pet updated = petRepository.save(existingPet);
                        return convertToDTO(updated);
                    });
        }

        public boolean deletePet(Long id) {
            return petRepository.findById(id).map(pet -> {
                petRepository.delete(pet);
                return true;
            }).orElse(false);
        }

        private void initializeDefaults(Pet pet) {
            if (pet.getLife() == 0) pet.setLife(100);
            if (pet.getHappiness() == 0) pet.setHappiness(100);
            if (pet.getEnergy() == 0) pet.setEnergy(100);
        }

        public PetDTO convertToDTO(Pet pet) {
            if (pet == null) return null;

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

        public Pet convertToEntity(PetDTO dto) {
            if (dto == null) return null;

            Pet pet = new Pet();
            pet.setId(dto.getId());
            pet.setName(dto.getName());
            pet.setPetColor(dto.getPetColor());
            pet.setPetType(dto.getPetType());
            pet.setEnvironment(dto.getEnvironment());
            pet.setComplement(dto.getComplement());
            pet.setLife(dto.getLife());
            pet.setHappiness(dto.getHappiness());
            pet.setEnergy(dto.getEnergy());

            return pet;
        }

        public void updateEntityFromDTO(PetDTO dto, Pet pet) {
            pet.setName(dto.getName());
            pet.setPetColor(dto.getPetColor());
            pet.setPetType(dto.getPetType());
            pet.setEnvironment(dto.getEnvironment());
            pet.setComplement(dto.getComplement());
            pet.setLife(dto.getLife());
            pet.setHappiness(dto.getHappiness());
            pet.setEnergy(dto.getEnergy());
        }
    }



