package be.vdab.Opdracht_6.orgs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class SaveOrganisation {
    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("mariacontainerDROP");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();

            Organisation realdolmen = new Organisation().setName("Realdolmen");
            Organisation vdab = new Organisation().setName("VDAB");

            Member elias = new Member().setName("Elias");
            Member klaas = new Member().setName("klaas");
            Member kevin = new Member().setName("Kevin");
            Member wouter = new Member().setName("Wouter");
            Member thomas = new Member().setName("Thomas");
            Member tibo = new Member().setName("Tibo");

            Set<Member> onlyElias = new HashSet<>();
            onlyElias.add(elias);

            Set<Member> everybody = new HashSet<>();
            everybody.add(elias);
            everybody.add(klaas);
            everybody.add(kevin);
            everybody.add(wouter);
            everybody.add(thomas);
            everybody.add(tibo);

            realdolmen.setMembers(onlyElias);
            vdab.setMembers(everybody);

            Set<Organisation> onlyVDAB = new HashSet<>();
            onlyVDAB.add(vdab);

            Set<Organisation> bothOrganisations = new HashSet<>();
            bothOrganisations.add(realdolmen);
            bothOrganisations.add(vdab);

            elias.setOrganisations(bothOrganisations);
            klaas.setOrganisations(onlyVDAB);
            kevin.setOrganisations(onlyVDAB);
            wouter.setOrganisations(onlyVDAB);
            thomas.setOrganisations(onlyVDAB);
            tibo.setOrganisations(onlyVDAB);

            tx.begin();

            em.persist(vdab);
            em.persist(realdolmen);

            em.persist(elias);
            em.persist(klaas);
            em.persist(wouter);
            em.persist(kevin);
            em.persist(thomas);
            em.persist(tibo);

            tx.commit();

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