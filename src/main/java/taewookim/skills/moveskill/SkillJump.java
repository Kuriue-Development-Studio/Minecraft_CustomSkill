package taewookim.skills.moveskill;

import org.bukkit.util.Vector;
import taewookim.skills.Skill;
import taewookim.util.ElementTypes;
import taewookim.util.SkillOwner;

public class SkillJump extends Skill {
    public SkillJump(SkillOwner owner, ElementTypes element, int power) {
        super(owner, element, power);
    }

    @Override
    protected void init(ElementTypes element, int power) {
        Vector v = new Vector(0, ((double)power)*0.5d, 0);
        if(owner.isTarget()) {
            owner.getTarget().setVelocity(v);
        }else if(owner.isOwner()) {
            owner.getOwner().setVelocity(v);
        }
    }

    @Override
    protected void update() {

    }
}
