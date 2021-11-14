package co.edu.unbosque.workshop5.services;

import co.edu.unbosque.workshop5.jpa.entities.Official;
import co.edu.unbosque.workshop5.jpa.repositories.OfficialImpl;
import co.edu.unbosque.workshop5.jpa.repositories.OfficialRepository;
import co.edu.unbosque.workshop5.servlet.pojo.OfficialPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OfficialService {

    OfficialRepository officialRepository;

    public OfficialPOJO create(String name){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialImpl(entityManager);
        Official official = new Official(name);
        officialRepository.create(official);

        entityManager.close();
        entityManagerFactory.close();

        OfficialPOJO officialPOJO = new OfficialPOJO(name);

    }
}
