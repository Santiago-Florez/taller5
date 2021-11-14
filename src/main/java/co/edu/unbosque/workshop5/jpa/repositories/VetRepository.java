package co.edu.unbosque.workshop5.jpa.repositories;

import co.edu.unbosque.workshop5.jpa.entities.Vet;

import java.util.List;
import java.util.Optional;

public interface VetRepository {

    Optional<Vet> save(Vet vet);

    List<Vet> findAll();
}
