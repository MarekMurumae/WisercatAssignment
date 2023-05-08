package eu.wisercat.petmanagmentapi.dao;

import eu.wisercat.petmanagmentapi.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    Optional<Pet> findByIdentificationCode(String identificationCode);

}
