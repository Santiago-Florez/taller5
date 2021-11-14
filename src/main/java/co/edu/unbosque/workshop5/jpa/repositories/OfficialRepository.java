package co.edu.unbosque.workshop5.jpa.repositories;

import co.edu.unbosque.workshop5.jpa.entities.Official;

import java.util.List;
import java.util.Optional;

public interface OfficialRepository {

    Optional<Official> create(Official off);

    List<Official> findAll();

    Optional<Official> updateName(String name, String username);

}
