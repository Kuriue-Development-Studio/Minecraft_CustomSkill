package taewookim.util;

import org.bukkit.Particle;

public enum ElementTypes {

    ELEMENT(Particle.CLOUD, Particle.SMOKE_LARGE);

    private final Particle main;
    private final Particle sub;

    ElementTypes(Particle main, Particle sub) {
        this.main = main;
        this.sub = sub;
    }

}
