package be.vdab.Opdracht_5.education;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany (mappedBy = "school",
                cascade = CascadeType.ALL)
    @OrderBy ("name ASC")
    private List<Student> students = new ArrayList<>();

    public void addStudent (Student student) {
        students.add(student);
        student.setSchool(this);
    }

    public void removeStudent (Student student) {
        students.remove(student);
        student.setSchool(null);
    }

    @Embedded
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students.toString() +
                '}';
    }
}
