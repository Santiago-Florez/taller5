package co.edu.unbosque.workshop5.jpa.repositories;

import co.edu.unbosque.workshop5.jpa.entities.Owner;
import co.edu.unbosque.workshop5.jpa.entities.Vet;

import java.util.List;
import java.util.Optional;

public interface VetRepository {

    Optional<Vet> save(Vet vet);

    List<Vet> findAll();

    Optional<Vet> updateName(String name, String username);

    Optional<Vet> updateAddress(String address, String username);

    Optional<Vet> updateNeighborhood(String neighborhood, String username);
}
