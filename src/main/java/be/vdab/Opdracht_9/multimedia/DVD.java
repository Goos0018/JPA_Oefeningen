package be.vdab.Opdracht_9.multimedia;

import javax.persistence.Entity;

@Entity
public class DVD extends AudioVisual{

    private int subtitles;

    public int getSubtitles() {
        return subtitles;
    }

    public DVD setSubtitles(int subtitles) {
        this.subtitles = subtitles;
        return this;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "subtitles=" + subtitles +
                super.toString();
    }
}
