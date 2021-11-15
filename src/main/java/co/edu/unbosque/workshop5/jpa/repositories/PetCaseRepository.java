package co.edu.unbosque.workshop5.jpa.repositories;

import co.edu.unbosque.workshop5.jpa.entities.Pet;
import co.edu.unbosque.workshop5.jpa.entities.PetCase;

import java.util.List;
import java.util.Optional;

public interface PetCaseRepository {

    Optional<PetCase> saveType(PetCase pet);

    List<PetCase> findAll();
}
