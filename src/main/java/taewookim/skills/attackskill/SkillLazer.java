package taewookim.skills.attackskill;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;
import taewookim.collisiondetector.element.Line;
import taewookim.skills.Skill;
import taewookim.util.ElementTypes;
import taewookim.util.SkillOwner;

import java.util.function.Predicate;

public class SkillLazer extends Skill {
    public SkillLazer(SkillOwner owner, ElementTypes element, int power) {
        super(owner, element, power);
    }

    @Override
    protected void init(ElementTypes element, int power) {
        if(owner.getOwner() instanceof LivingEntity le) {
            Location loc = owner.getLocation();
            Vector v = loc.getDirection();
            double x = loc.getX();
            double y = loc.getY();
            double z = loc.getZ();
            World w = loc.getWorld();
            BoundingBox box = new BoundingBox(x-0.5, y-0.5, z-0.5, x+0.5, y+0.5, z+0.5);
            for(int i = 0; i<5*power; i++) {
                box.shift(loc.add(v));
                w.spawnParticle(element.getMainParticle(), loc, 5, .5, .5, .5, .1);
                for(Entity en : w.getNearbyEntities(box, new Predicate<Entity>() {
                    @Override
                    public boolean test(Entity entity) {
                        return !entity.equals(le)&&entity instanceof LivingEntity;
                    }
                })) {
                    element.damage(le, ((LivingEntity) en), power);
                }
            }
        }
    }

    @Override
    protected void update() {

    }
}
