package taewookim.skills.utilskill;

import org.bukkit.entity.LivingEntity;
import taewookim.skills.Skill;
import taewookim.util.ElementTypes;
import taewookim.util.SkillOwner;

public class SkillTargetMe extends Skill {
    public SkillTargetMe(SkillOwner owner, ElementTypes element, int power) {
        super(owner, element, power);
    }

    @Override
    protected void init(ElementTypes element, int power) {
        if(owner.isOwner()&& owner.getOwner() instanceof LivingEntity tar) {
            owner.setTarget(tar);
        }
    }

    @Override
    protected void update() {

    }
}
