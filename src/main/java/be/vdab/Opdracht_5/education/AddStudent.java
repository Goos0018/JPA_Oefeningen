package be.vdab.Opdracht_5.education;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AddStudent {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("none");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            School school = em.find(School.class, 1L);
            school.addStudent(new Student ("Bert"));
            em.persist(school);
            tx.commit();
            System.out.println("student added to school " + school.getName());
        } finally {
            if (emf != null)
                emf.close();
            if (em != null)
                em.close();
        }
    }
}
