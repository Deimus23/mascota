package itacademy.mascota.service;

import itacademy.mascota.dto.CreatePetDTO;
import itacademy.mascota.dto.PetDTO;
import itacademy.mascota.model.Pet;
import itacademy.mascota.model.User;
import itacademy.mascota.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

    @Service
    public class PetService {

        @Autowired
        private PetRepository petRepository;
        @Autowired
        private AuthService authService;

        public List<PetDTO> getAllPets() {
            return petRepository.findAll().stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        }

        public PetDTO getPetById(Long id) {
            Optional<Pet> petOptional = petRepository.findById(id);
            if (petOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            return this.convertToDTO(petOptional.get());
        }

        public List<PetDTO> getMyPets() {
            User user = authService.getCurrentUser();
            return user.getPets()
                    .stream()
                    .map(this::convertToDTO)
                    .toList();
        }

        public PetDTO createPet(CreatePetDTO petDTO) {
            Pet pet = this.initializeNewPet(petDTO);
            Pet saved = petRepository.save(pet);
            return convertToDTO(saved);
        }

        public PetDTO updatePet(Long id, PetDTO petDTO) {
            Optional<Pet> petOptional = petRepository.findById(id);
            if (petOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            Pet originalpet = petOptional.get();
            originalpet.setPetType(petDTO.getPetType());
            originalpet.setPetColor(petDTO.getPetColor());
            Pet savedPet = petRepository.save(originalpet);
            return convertToDTO(savedPet);
        }


        public boolean deletePet(Long id) {
            return petRepository.findById(id).map(pet -> {
                petRepository.delete(pet);
                return true;
            }).orElse(false);
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

        private Pet initializeNewPet(CreatePetDTO petDTO) {
            Pet newPet = new Pet();
            //init values from dto
            newPet.setName(petDTO.getName());
            newPet.setPetType(petDTO.getPetType());
            newPet.setPetColor(petDTO.getPetColor());
            newPet.setComplement(petDTO.getComplement());

            //init default values
            newPet.setHappiness(100);
            newPet.setEnergy(100);
            newPet.setLife(100);
            return newPet;
        }

    }


