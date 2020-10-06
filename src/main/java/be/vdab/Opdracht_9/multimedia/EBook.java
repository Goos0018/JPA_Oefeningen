package be.vdab.Opdracht_9.multimedia;

import javax.persistence.Entity;

@Entity
public class EBook extends Book{

    private String url;

    public String getUrl() {
        return url;
    }

    public EBook setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public String toString() {
        return "EBook{" +
                "url='" + url + '\'' +
                super.toString();
    }
}

