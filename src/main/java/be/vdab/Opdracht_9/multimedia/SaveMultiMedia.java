package be.vdab.Opdracht_9.multimedia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveMultiMedia {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("drop-and-create");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            MultiMedia livre = new Book().setPages(200).setAuthor("De Bel").setName("Boeboek")
                    .setPublisher("VanIn");

            MultiMedia eLivre = new EBook().setUrl("http://www.ebook.com");

            MultiMedia black = new CD().setTracks(10).setDuration(50).setAuthor("Metallica");

            MultiMedia dvd = new DVD().setSubtitles(12);

            em.persist(livre);
            em.persist(eLivre);
            em.persist(black);
            em.persist(dvd);

            tx.commit();

            System.out.println("saved");
        } finally {
            if (emf != null)
                emf.close();
            if (em != null)
                em.close();
        }
    }
}
