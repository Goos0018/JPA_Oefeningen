package be.vdab.Opdracht_9.multimedia;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn (name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class MultiMedia {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String author;
    private LocalDate pubDate;
    private String publisher;

    public long getId() {
        return id;
    }

    public MultiMedia setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MultiMedia setName(String name) {
        this.name = name;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public MultiMedia setAuthor(String author) {
        this.author = author;
        return this;
    }

    public LocalDate getPubDate() {
        return pubDate;
    }

    public MultiMedia setPubDate(LocalDate pubDate) {
        this.pubDate = pubDate;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public MultiMedia setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    @Override
    public String toString() {
        return "MultiMedia{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pubDate=" + pubDate +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
