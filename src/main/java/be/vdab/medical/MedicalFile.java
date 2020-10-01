package be.vdab.medical;

import javax.persistence.*;

@Entity
public class MedicalFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float height;
    private float weight;

    @OneToOne (mappedBy = "medicalFile")
    private Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public long getId() {
        return id;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return  "height = " + height +
                ", weight = " + weight;
    }
}
