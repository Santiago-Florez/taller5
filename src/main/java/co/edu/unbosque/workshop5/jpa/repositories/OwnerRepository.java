package co.edu.unbosque.workshop5.jpa.repositories;

import co.edu.unbosque.workshop5.jpa.entities.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository {

    Optional<Owner> create(Owner off);

    List<Owner> findAll();

    Optional<Owner> updateAll(String name, String address,String neighborhood, String username);

    Optional<Owner> updateName(String name, String username);

    Optional<Owner> updateAddress(String address, String username);

    Optional<Owner> updateNeighborhood(String neighborhood, String username);
}
