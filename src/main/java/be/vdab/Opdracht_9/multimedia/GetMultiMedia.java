package be.vdab.Opdracht_9.multimedia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetMultiMedia {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("none");
            em = emf.createEntityManager();

            MultiMedia media = em.find(MultiMedia.class, 2L);
            MultiMedia media2 = em.find(MultiMedia.class, 4L);
            MultiMedia media3 = em.find(MultiMedia.class, 1L);


            System.out.println(media);
            System.out.println(media2);
            System.out.println(media3);

        } finally {
            if (emf != null)
                emf.close();
            if (em != null)
                em.close();
        }
    }
}
