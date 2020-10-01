package be.vdab.education;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class SaveSchool {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            School school = new School();
            List<Student> students = new ArrayList<>();
            Student student = new Student("Benny");
            Student student2 = new Student("Kristof");
            Student student3 = new Student("Dieter");
            students.add(student);
            students.add(student2);
            students.add(student3);
            school.setName("College Boom");
            school.setStudents(students);
            em.persist(school);
            tx.commit();
            System.out.println("School saved");
        } finally {
            if (emf != null)
                emf.close();
            if (em != null)
                em.close();
        }
    }
}
