package taewookim.skills.utilskill;

import org.bukkit.util.Vector;
import taewookim.CustomSkillPlugin;
import taewookim.skills.Skill;
import taewookim.util.ElementTypes;
import taewookim.util.SkillOwner;

public class SkillRandomPosition extends Skill {
    public SkillRandomPosition(SkillOwner owner, ElementTypes element, int power) {
        super(owner, element, power);
    }

    @Override
    protected void init(ElementTypes element, int power) {
        owner.getLocation().add(Vector.getRandom().multiply(CustomSkillPlugin.plugin.r.nextDouble()*power*2));
    }

    @Override
    protected void update() {

    }
}
