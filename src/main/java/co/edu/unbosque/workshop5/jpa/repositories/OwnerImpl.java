package co.edu.unbosque.workshop5.jpa.repositories;

import co.edu.unbosque.workshop5.jpa.entities.Owner;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class OwnerImpl implements OwnerRepository{

    private EntityManager entityManager;

    public OwnerImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Owner> create(Owner off) {
        return Optional.empty();
    }

    @Override
    public List<Owner> findAll() {
        return entityManager.createQuery("from Owner").getResultList();
    }

    @Override
    public Optional<Owner> updateAll(String name, String address, String neighborhood, String username) {
        Owner ow = (Owner) entityManager.createQuery("UPDATE Owner ow SET ow.name = :name, ow.address = :address " +
                ", ow.neighborhood = :neighborhood WHERE ow.username = :username").setParameter("name",name)
                .setParameter("address",address).setParameter("neighborhood", neighborhood).getSingleResult();
        return ow != null ? Optional.of(ow) : Optional.empty();
    }

    @Override
    public Optional<Owner> updateName(String name, String username) {
        Owner ow = (Owner) entityManager.createQuery("UPDATE Owner ow SET ow.name = :name WHERE ow.username = :username")
                .setParameter("name",name).getSingleResult();
        return ow != null ? Optional.of(ow) : Optional.empty();
    }

    @Override
    public Optional<Owner> updateAddress(String address, String username) {
        Owner ow = (Owner) entityManager.createQuery("UPDATE Owner ow SET ow.address = :address WHERE ow.username = :username")
                .setParameter("address",address).getSingleResult();
        return ow != null ? Optional.of(ow) : Optional.empty();
    }

    @Override
    public Optional<Owner> updateNeighborhood(String neighborhood, String username) {
        Owner ow = (Owner) entityManager.createQuery("UPDATE Owner ow SET ow.neighborhood = :neighborhood WHERE ow.username = :username")
                .setParameter("neighborhood", neighborhood).getSingleResult();
        return ow != null ? Optional.of(ow) : Optional.empty();
    }
}
