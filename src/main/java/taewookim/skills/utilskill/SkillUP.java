package taewookim.skills.utilskill;

import org.bukkit.util.Vector;
import taewookim.skills.Skill;
import taewookim.util.ElementTypes;
import taewookim.util.SkillOwner;

public class SkillUP extends Skill {
    public SkillUP(SkillOwner owner, ElementTypes element, int power) {
        super(owner, element, power);
    }

    @Override
    protected void init(ElementTypes element, int power) {
        owner.setDirection(new Vector(0, 1, 0));
    }

    @Override
    protected void update() {

    }
}
