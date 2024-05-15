package taewookim.skills.utilskill;

import taewookim.skills.Skill;
import taewookim.util.ElementTypes;
import taewookim.util.SkillOwner;

public class SkillRandomDirection extends Skill {
    public SkillRandomDirection(SkillOwner owner, ElementTypes element, int power) {
        super(owner, element, power);
    }

    @Override
    protected void init(ElementTypes element, int power) {
        owner.resetDirection();
    }

    @Override
    protected void update() {

    }
}
