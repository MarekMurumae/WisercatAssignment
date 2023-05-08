package eu.wisercat.petmanagmentapi.service;

import eu.wisercat.petmanagmentapi.dao.PetRepository;
import eu.wisercat.petmanagmentapi.exception.PetNotFoundException;
import eu.wisercat.petmanagmentapi.model.Pet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    public Pet findById(long id) throws PetNotFoundException {
        return petRepository.findById(id)
                .orElseThrow((() -> new PetNotFoundException(String.format("Pet not found with id=%s", id))));
    }

    public Pet findByIdentificationCode(String identificationCode) throws PetNotFoundException {
        return petRepository.findByIdentificationCode(identificationCode)
                .orElseThrow((() -> new PetNotFoundException(String.format("Pet not found with identification code=%s",
                        identificationCode))));
    }

    public Pet add(Pet pet) {
        boolean exists = petRepository.findByIdentificationCode(pet.getIdentificationCode()).isPresent();
        if (!exists) return petRepository.save(pet);
        throw new IllegalArgumentException(String.format("Pet with identification code=%s already exists",
                pet.getIdentificationCode()));
    }

    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }
}
