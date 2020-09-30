package be.vdab.restaurant;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Collection;

public class SaveMenu {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Menu menu = new Menu();
            menu.setTitle("Konijn met pruimen");
            Ingredient konijn = new Ingredient(1, "konijn");
            Ingredient pruimen = new Ingredient(4, "pruimen");
            Collection<Ingredient> ingredients = new ArrayList<>();
            ingredients.add(konijn);
            ingredients.add(pruimen);
            menu.setIngredients(ingredients);
            em.persist(menu);
            tx.commit();
            System.out.println("Menu saved");
        } finally {
            if (em != null)
                em.close();
            if (emf != null)
                emf.close();
        }
    }
}
