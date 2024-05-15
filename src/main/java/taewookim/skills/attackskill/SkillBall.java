package taewookim.skills.attackskill;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;
import taewookim.BattleSystemPlugin;
import taewookim.skills.Skill;
import taewookim.util.ElementTypes;
import taewookim.util.SkillOwner;

import java.util.function.Predicate;

public class SkillBall extends Skill {
    public SkillBall(SkillOwner owner, ElementTypes element, int power) {
        super(owner, element, power);
    }

    private Vector v;
    private Location loc;
    private World w;
    private double d;
    private BoundingBox box;
    private Predicate<Entity> predict;
    private double damage=0;
    private LivingEntity damager;

    @Override
    protected void init(ElementTypes element, int power) {
        loc = owner.getLocation();
        w = loc.getWorld();
        v = loc.getDirection().multiply(0.2);
        tick = power*50;
        d = 0.1*power;
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();
        box = new BoundingBox(x-d, y-d, z-d, x+d, y+d, z+d);
        if(owner.getOwner() instanceof LivingEntity le) {
            predict = new Predicate<Entity>() {
                @Override
                public boolean test(Entity entity) {
                    return !entity.equals(le)&&entity instanceof LivingEntity;
                }
            };
            damage = BattleSystemPlugin.getDamage(le);
            damager = le;
        }
    }

    @Override
    protected void update() {
        loc.add(v);
        box.shift(v);
        w.spawnParticle(element.getMainParticle(), loc, power, d, d, d, 0.05);
        if(damage>0) {
            for(Entity en : w.getNearbyEntities(box, predict)) {
                BattleSystemPlugin.Damage(damager, ((LivingEntity) en), damage);
                tick = 0;
                return;
            }
        }
        if(!loc.getBlock().isPassable()) {
            tick = 0;
        }
    }
}
