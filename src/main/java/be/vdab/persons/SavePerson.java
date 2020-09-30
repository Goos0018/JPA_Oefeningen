package be.vdab.persons;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePerson {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Person person = new Person();
            person.setFirstName("Thomas");
            person.setLastName("Goos");
            person.setGender(GenderType.MALE);
            Address address = new Address();
            address.setStreet("Dirkputstraat");
            address.setNumber("440");
            address.setZipCode("2850");
            address.setCity("Boom");
            address.setCountry("Belgium");
            person.setAddress(address);
            em.persist(person);
            tx.commit();
            System.out.println("Person saved");
        } finally {
            if (em != null)
                em.close();
            if (emf != null)
                emf.close();
        }
    }
}
