package taewookim.skills.utilskill;

import taewookim.skills.Skill;
import taewookim.util.ElementTypes;
import taewookim.util.SkillOwner;

public class SkillTarget extends Skill {

    public SkillTarget(SkillOwner owner, ElementTypes element, int power) {
        super(owner, element, power);
    }

    @Override
    protected void init(ElementTypes element, int power) {

    }

    @Override
    protected void update() {
    }
}
