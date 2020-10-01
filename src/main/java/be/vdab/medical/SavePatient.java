package be.vdab.medical;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePatient {
    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Patient patient = new Patient();
            MedicalFile medicalFile = new MedicalFile();
            patient.addMedicalFile(medicalFile);
            patient.setName("Tony");
            medicalFile.setHeight(140F);
            medicalFile.setWeight(150F);
            em.persist(medicalFile);
            em.persist(patient);
            tx.commit();
            System.out.println("Patient saved");
        } finally {
            if (emf != null)
                emf.close();
            if (em != null)
                em.close();
        }
    }
}
