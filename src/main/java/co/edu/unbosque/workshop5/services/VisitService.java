package co.edu.unbosque.workshop5.services;

import co.edu.unbosque.workshop5.jpa.entities.Visit;
import co.edu.unbosque.workshop5.jpa.repositories.VisitImpl;
import co.edu.unbosque.workshop5.jpa.repositories.VisitRepository;
import co.edu.unbosque.workshop5.servlet.pojo.VisitPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Stateless
public class VisitService {

    VisitRepository visitRepository;

    public VisitPOJO save(Integer visitId, String createdAt, String type, String description, Integer vetId, Integer petId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitImpl(entityManager);
        Visit visit = new Visit(visitId, createdAt, type, description, vetId, petId);
    }
}
