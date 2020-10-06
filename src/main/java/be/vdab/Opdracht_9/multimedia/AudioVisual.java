package be.vdab.Opdracht_9.multimedia;

import javax.persistence.Entity;

@Entity
public abstract class AudioVisual extends MultiMedia{

    private long duration;

    public long getDuration() {
        return duration;
    }

    public AudioVisual setDuration(long duration) {
        this.duration = duration;
        return this;
    }

    @Override
    public String toString() {
        return "AudioVisual{" +
                "duration=" + duration +
                super.toString();
    }
}
