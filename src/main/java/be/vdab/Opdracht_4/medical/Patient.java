package be.vdab.Opdracht_4.medical;

import javax.persistence.*;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToOne(  orphanRemoval = true,
                cascade = CascadeType.REMOVE,
                fetch = FetchType.LAZY)
    @JoinColumn (name = "idMedicalFile")
    private MedicalFile medicalFile;

    public void addMedicalFile (MedicalFile mf){
        medicalFile = mf;
        mf.setPatient(this);
    }

    public void removeMedicalFile(){
        if (medicalFile != null){
            medicalFile.setPatient(null);
            medicalFile = null;
        }
    }

    public MedicalFile getMedicalFile() {
        return medicalFile;
    }

    public void setMedicalFile(MedicalFile medicalFile) {
        this.medicalFile = medicalFile;
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
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", medicalFile=" + medicalFile.toString() +
                '}';
    }
}
