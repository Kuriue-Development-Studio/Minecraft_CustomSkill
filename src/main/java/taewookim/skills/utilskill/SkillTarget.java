package taewookim.skills.utilskill;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.RayTraceResult;
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
        int lengh = power*7;
        RayTraceResult result = loc.getWorld().rayTraceEntities(loc, loc.getDirection(), lengh, new Predicate<Entity>() {
            @Override
            public boolean test(Entity entity) {
                return !entity.equals(owner.getOwner())&&entity instanceof LivingEntity;
            }
        });
        if(result!=null&&result.getHitEntity() instanceof LivingEntity le) {
            owner.setTarget(le);
        }else if(owner.getOwner() instanceof Player p) {
            owner.setLocation(p.getTargetBlock(null, lengh).getLocation());
        }
    }

    @Override
    protected void update() {
    }
}
