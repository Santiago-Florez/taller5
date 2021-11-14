package co.edu.unbosque.workshop5.jpa.repositories;

import co.edu.unbosque.workshop5.jpa.entities.Pet;

import java.util.List;
import java.util.Optional;

public interface PetCaseRepository {

    Optional<Pet> saveType(Pet pet);

    List<Pet> findAll();
}
