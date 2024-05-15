package taewookim.skills.attackskill;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import taewookim.skills.Skill;
import taewookim.util.ElementTypes;
import taewookim.util.SkillOwner;

import java.util.function.Predicate;

public class SkillExplosion extends Skill {
    public SkillExplosion(SkillOwner owner, ElementTypes element, int power) {
        super(owner, element, power);
    }

    @Override
    protected void init(ElementTypes element, int power) {
        Location loc = owner.getLocation();
        World w = loc.getWorld();
        w.spawnParticle(Particle.EXPLOSION_HUGE, loc, 1);
        w.spawnParticle(element.getMainParticle(), loc, 10, 0, 0, 0, 0.5);
        if(power>3) {
            w.spawnParticle(element.getSubParticle(), loc, 10, 0, 0, 0, 0.5);
        }
        if(owner.getOwner() instanceof LivingEntity le) {
            for(Entity en : w.getNearbyEntities(loc, 3, 3, 3, new Predicate<Entity>() {
                @Override
                public boolean test(Entity entity) {
                    return !entity.equals(le)&&entity instanceof LivingEntity;
                }
            })) {
                element.damage(le, ((LivingEntity) en), power);
            }
        }
    }

    @Override
    protected void update() {

    }
}
