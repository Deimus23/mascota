package itacademy.mascota.repository;
import itacademy.mascota.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findByName(String name);
    List<Pet> findByOwnerUsername(String username);
}

