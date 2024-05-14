package taewookim.skills.utilskill;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;
import taewookim.skills.Skill;
import taewookim.util.ElementTypes;
import taewookim.util.SkillOwner;

import java.util.function.Predicate;

public class SkillTarget extends Skill {

    public SkillTarget(SkillOwner owner, ElementTypes element, int power) {
        super(owner, element, power);
    }

    @Override
    protected void init(ElementTypes element, int power) {
        Location loc = owner.getLocation();
        owner.setTarget((LivingEntity) loc.getWorld().rayTraceEntities(loc, loc.getDirection(), power * 7, new Predicate<Entity>() {
            @Override
            public boolean test(Entity entity) {
                return entity instanceof LivingEntity;
            }
        }).getHitEntity());
    }

    @Override
    protected void update() {
    }
}
