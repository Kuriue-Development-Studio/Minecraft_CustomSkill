package taewookim.skills.utilskill;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;
import taewookim.skills.Skill;
import taewookim.util.ElementTypes;
import taewookim.util.SkillOwner;

public class SkillTarget extends Skill {

    public SkillTarget(SkillOwner owner, ElementTypes element, int power) {
        super(owner, element, power);
    }

    @Override
    protected void init(ElementTypes element, int power) {
        World w = owner.getWorld();
        double[] location = owner.getLocation();
        double[] direction = owner.getDiraction();
        w.rayTraceEntities(new Location(w, location[0], location[1], location[2]), new Vector(direction[0], direction[1], direction[2]), power*7);
    }

    @Override
    protected void update() {
    }
}
