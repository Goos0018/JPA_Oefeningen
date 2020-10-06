package be.vdab.Opdracht_6.library;

import javax.persistence.*;

@Entity
@Embeddable
public class Magazine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public Magazine setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}