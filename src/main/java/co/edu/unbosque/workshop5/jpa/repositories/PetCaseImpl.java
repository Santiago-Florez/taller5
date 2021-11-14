package co.edu.unbosque.workshop5.jpa.repositories;

import co.edu.unbosque.workshop5.jpa.entities.Pet;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class PetCaseImpl implements PetCaseRepository{

    private EntityManager entityManager;

    @Override
    public Optional<Pet> saveType(Pet pet) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(pet);
            entityManager.getTransaction().commit();
            return Optional.of(pet);
        }catch(Exception e){
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Pet> findAll() {
        return entityManager.createQuery("from PetCase ").getResultList();
    }
}
