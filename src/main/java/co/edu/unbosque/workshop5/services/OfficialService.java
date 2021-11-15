package co.edu.unbosque.workshop5.services;

import co.edu.unbosque.workshop5.jpa.entities.Official;
import co.edu.unbosque.workshop5.jpa.repositories.OfficialImpl;
import co.edu.unbosque.workshop5.jpa.repositories.OfficialRepository;
import co.edu.unbosque.workshop5.servlet.pojo.OfficialPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OfficialService {

    OfficialRepository officialRepository;

    public OfficialPOJO create(String username, String name){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialImpl(entityManager);
        Official official = new Official(name);
        officialRepository.create(official);

        entityManager.close();
        entityManagerFactory.close();

        OfficialPOJO officialPOJO = new OfficialPOJO(name);

        return officialPOJO;
    }

    public OfficialPOJO updateName(String name, String username){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialImpl(entityManager);
        officialRepository.updateName(name, username);

        List<Official> officials = officialRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        OfficialPOJO officialPOJO = new OfficialPOJO();

        for (Official official: officials){
            if(official.getUsername().equals(username)){
                officialPOJO = new OfficialPOJO(official.getName());
            }
        }
        return officialPOJO;
    }

    public List<OfficialPOJO> findAll(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("workshop5");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialImpl(entityManager);
        List<Official> getofficials = officialRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<OfficialPOJO> officialPOJOS = new ArrayList<>();
        for (Official official: getofficials){
            officialPOJOS.add(new OfficialPOJO(official.getUsername().getUsername(), official.getName()));
        }

        return officialPOJOS;
    }
}
