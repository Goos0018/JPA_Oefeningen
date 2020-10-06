package be.vdab.Opdracht_6.library;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToMany
    private Set<Magazine> magazines = new HashSet<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Reader setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Magazine> getMagazines() {
        return magazines;
    }

    public Reader setMagazines(Set<Magazine> magazines) {
        this.magazines = magazines;
        return this;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", magazines=" + magazines +
                '}';
    }
}