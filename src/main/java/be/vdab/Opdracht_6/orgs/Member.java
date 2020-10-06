package be.vdab.Opdracht_6.orgs;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Member {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToMany
    @JoinTable (name = "ORG_MEMBER",
                joinColumns = @JoinColumn (name = "MEM_ID"),
                inverseJoinColumns = @JoinColumn (name = "ORG_ID"))
    private Set<Organisation> organisations = new HashSet<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Member setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Organisation> getOrganisations() {
        return organisations;
    }

    public Member setOrganisations(Set<Organisation> organisations) {
        this.organisations = organisations;
        return this;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", organisations=" + organisations.toString() +
                '}';
    }
}
