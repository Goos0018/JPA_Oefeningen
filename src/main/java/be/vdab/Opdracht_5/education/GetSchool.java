package be.vdab.Opdracht_5.education;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetSchool {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("none");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
//            tx.begin();
            School school = em.find(School.class, 1L);
//            tx.commit();
            System.out.println("test");
            System.out.println(school.toString());

        } finally {
            if (emf != null)
                emf.close();
            if (em != null)
                em.close();
        }
    }

}
