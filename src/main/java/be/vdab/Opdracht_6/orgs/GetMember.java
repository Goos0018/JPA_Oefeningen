package be.vdab.Opdracht_6.orgs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetMember {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("none");
            em = emf.createEntityManager();

            Member member = em.find(Member.class, 1L);
            System.out.println(member.getOrganisations());
        } finally {
            if (emf != null)
                emf.close();
            if (em != null)
                em.close();
        }

    }
}
