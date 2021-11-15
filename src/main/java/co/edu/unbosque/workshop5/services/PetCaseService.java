package co.edu.unbosque.workshop5.services;

import co.edu.unbosque.workshop5.jpa.entities.PetCase;
import co.edu.unbosque.workshop5.jpa.repositories.PetCaseImpl;
import co.edu.unbosque.workshop5.jpa.repositories.PetCaseRepository;
import co.edu.unbosque.workshop5.servlet.pojo.PetCasePOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PetCaseService {

    PetCaseRepository petCaseRepository;

    public PetCasePOJO save(Integer caseId, String createdAt, String type, String description, Integer petId){
        if (!type.equals("perdida") || !type.equals("robo") || !type.equals("fallecimiento")){
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            petCaseRepository = new PetCaseImpl(entityManager);
            PetCase petCase = new PetCase(createdAt,type,description);
            petCaseRepository.saveType(petCase);

            entityManager.close();
            entityManagerFactory.close();

            PetCasePOJO petCasePOJO = new PetCasePOJO(caseId,createdAt,type,description, petId);

            return petCasePOJO;
        }else{
            return null;
        }
    }

    public List<PetCasePOJO> findAll(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petCaseRepository = new PetCaseImpl(entityManager);
        List<PetCase> getCase = petCaseRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<PetCasePOJO> petCasePOJOS = new ArrayList<>();
        for(PetCase petCase : getCase){
            petCasePOJOS.add(new PetCasePOJO(petCase.getCaseId(),petCase.getCreated_at(),petCase.getType(),petCase.getDescription(), petCase.getPetId().getPetId()));
        }

        return petCasePOJOS;
    }
}
