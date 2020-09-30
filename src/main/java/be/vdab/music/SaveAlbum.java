package be.vdab.music;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class SaveAlbum {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Album album = new Album();
            album.setAuthor("Arctic Monkeys");
            album.setTitle("AM");
            List<String> tracks = new ArrayList<>();
            tracks.add("Do I Wanna Know?");
            tracks.add("R U Mine?");
            tracks.add("One For The Road");
            tracks.add("Arabella");
            tracks.add("I Want It All");
            tracks.add("No. 1 Party Anthem");
            tracks.add("Mad Sounds");
            tracks.add("Fireside");
            tracks.add("Why'd You Only Call Me When You're High?");
            tracks.add("Snap Out Of It");
            tracks.add("Knee Socks");
            tracks.add("I Wanna Be Yours");
            album.setTracks(tracks);
            em.persist(album);
            tx.commit();
            System.out.println("Album saved");
        } finally {
            if (em != null)
                em.close();
            if (emf != null)
                emf.close();
        }
    }
}
