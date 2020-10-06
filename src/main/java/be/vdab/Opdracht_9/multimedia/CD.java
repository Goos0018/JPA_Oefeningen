package be.vdab.Opdracht_9.multimedia;

import javax.persistence.Entity;

@Entity
public class CD extends AudioVisual{

    private int tracks;

    public int getTracks() {
        return tracks;
    }

    public CD setTracks(int tracks) {
        this.tracks = tracks;
        return this;
    }

    @Override
    public String toString() {
        return "CD{" +
                "tracks=" + tracks +
                super.toString();
    }
}
