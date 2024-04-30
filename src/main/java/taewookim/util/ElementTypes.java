package taewookim.util;

import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import taewookim.BattleSystemPlugin;

public enum ElementTypes {

    ELEMENT(Particle.CLOUD, Particle.SMOKE_LARGE, new ElementDamager() {
        @Override
        public void entityDamage(LivingEntity damager, LivingEntity target) {
            BattleSystemPlugin.Damage(damager, target, BattleSystemPlugin.getDamage(damager));
        }
    });


    private final Particle main;
    private final Particle sub;
    private final ElementDamager elementdamager;

    ElementTypes(Particle main, Particle sub, ElementDamager elementdamager) {
        this.main = main;
        this.sub = sub;
        this.elementdamager = elementdamager;
    }

    public void damage(LivingEntity damager, LivingEntity target) {
        elementdamager.entityDamage(damager, target);
    }

}
