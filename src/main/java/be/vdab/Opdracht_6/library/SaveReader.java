package be.vdab.Opdracht_6.library;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class SaveReader {
    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("drop-and-create");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Reader testReader1 = new Reader();
            testReader1.setName("Don Rickles");
            Reader testReader2 = new Reader();
            testReader2.setName("Johnny Carson");

            Magazine testMag1 = new Magazine();
            testMag1.setTitle("Life");
            Magazine testMag2 = new Magazine();
            testMag2.setTitle("National Geographic");
            Magazine testMag3 = new Magazine();
            testMag3.setTitle("Esquire");
            Magazine testMag4 = new Magazine();
            testMag4.setTitle("Autoweek");

            Set<Magazine> reader1Magazines = new HashSet<>();
            reader1Magazines.add(testMag1);
            reader1Magazines.add(testMag2);
            reader1Magazines.add(testMag3);

            Set<Magazine> reader2Magazines = new HashSet<>();
            reader2Magazines.add(testMag1);
            reader2Magazines.add(testMag3);
            reader2Magazines.add(testMag4);

            testReader1.setMagazines(reader1Magazines);
            testReader2.setMagazines(reader2Magazines);

            em.persist(testReader1);
            em.persist(testReader2);
            em.persist(testMag1);
            em.persist(testMag2);
            em.persist(testMag3);
            em.persist(testMag4);
            tx.commit();
            System.out.println("Saved");

        } finally {
            if (em != null)
                em.close();
            if (emf != null)
                emf.close();
        }
    }
}
