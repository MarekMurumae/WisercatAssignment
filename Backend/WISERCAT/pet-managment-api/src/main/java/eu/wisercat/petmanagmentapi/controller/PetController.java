package eu.wisercat.petmanagmentapi.controller;

import eu.wisercat.petmanagmentapi.model.Pet;
import eu.wisercat.petmanagmentapi.model.PetDto;
import eu.wisercat.petmanagmentapi.service.PetService;
import jakarta.persistence.EntityNotFoundException;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pet")
@RequiredArgsConstructor
@CrossOrigin
public class PetController {

    private final PetService petService;

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable Long id) {
        if (id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Pet pet = petService.findById(id);
        return ResponseEntity.ok(pet);
    }

    @GetMapping("/code/{identificationCode}")
    public ResponseEntity<Pet> getByCode(@PathVariable Long identificationCode) {
        if (identificationCode == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Pet pet = petService.findByIdentificationCode(identificationCode.toString());
        return ResponseEntity.ok(pet);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pet>> getPets() {
        return ResponseEntity.ok(petService.findAll());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pet> addPet(@RequestBody PetDto petDto) {
        if (petDto == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Pet savedPet = Pet.builder()
                .name(petDto.getName())
                .identificationCode(petDto.getIdentificationCode())
                .type(petDto.getType())
                .furColor(petDto.getFurColor())
                .country(petDto.getCountry())
                .build();

        Pet saved = petService.add(savedPet);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/edit")
    public ResponseEntity<Pet> editPet(@RequestBody PetDto petDto) throws EntityNotFoundException {
        if (petDto == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Pet editable = petService.findByIdentificationCode(String.valueOf(petDto.getIdentificationCode()));
        if (editable == null) {
            throw new EntityNotFoundException("Pet with identificationCode " + petDto.getIdentificationCode() + " not found.");
        }

        // update the fields of the existing pet
        editable.setName(petDto.getName());
        editable.setType(petDto.getType());
        editable.setFurColor(petDto.getFurColor());
        editable.setCountry(petDto.getCountry());

        Pet saved = petService.save(editable);

        return ResponseEntity.status(HttpStatus.OK).body(saved);
    }

}
