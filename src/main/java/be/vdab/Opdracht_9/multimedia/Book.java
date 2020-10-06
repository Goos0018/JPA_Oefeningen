package be.vdab.Opdracht_9.multimedia;

import javax.persistence.Entity;

@Entity
public class Book extends MultiMedia{

    private int pages;

    public int getPages() {
        return pages;
    }

    public Book setPages(int pages) {
        this.pages = pages;
        return this;
    }



    @Override
    public String toString() {
        return "Book{" +
                "pages=" + pages +
                super.toString();
    }
}
