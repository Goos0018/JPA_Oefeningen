package be.vdab.Opdracht_5.education;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveSchool {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("drop-and-create");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            School school = new School();
            school.addStudent(new Student("Benny"));
            school.addStudent(new Student("Kristof"));
            school.addStudent(new Student("Dieter"));
            school.setName("College Boom");
            em.persist(school);
            tx.commit();
            System.out.println("School saved");
        } finally {
            if (emf != null)
                emf.close();
            if (em != null)
                em.close();
        }
    }
}
