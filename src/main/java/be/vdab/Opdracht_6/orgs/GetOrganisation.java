package be.vdab.Opdracht_6.orgs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetOrganisation {

    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("mariacontainerNONE");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            Member vdab = em.find(Member.class, 1L);
            Member realdolmen = em.find(Member.class, 2L);

            tx.commit();

            System.out.println(vdab.toString());
            System.out.println(realdolmen.toString());

        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}