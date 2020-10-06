package be.vdab.Opdracht_6.library;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetReader {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("none");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Reader reader1 = em.find(Reader.class, 1L);
            Reader reader2 = em.find(Reader.class, 2L);
            tx.commit();
            System.out.println("A list of readers and their choice of magazines:");
            System.out.println(reader1.toString());
            System.out.println(reader2.toString());
        } finally {
            if (emf != null)
                emf.close();
            if (em != null)
                em.close();
        }
    }
}

