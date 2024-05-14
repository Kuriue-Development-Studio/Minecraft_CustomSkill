package taewookim.skills.attackskill;

import org.bukkit.entity.LivingEntity;
import taewookim.BattleSystemPlugin;
import taewookim.skills.Skill;
import taewookim.util.ElementTypes;
import taewookim.util.SkillOwner;

public class SkillPain extends Skill {

    public SkillPain(SkillOwner owner, ElementTypes element, int power) {
        super(owner, element, power);
    }

    @Override
    protected void init(ElementTypes element, int power) {
        if(owner.isOwner()&&owner.getOwner() instanceof LivingEntity le) {
            if(owner.isTarget()) {
                owner.getTarget().damage(BattleSystemPlugin.getDamage(le)*((double)power)*0.2D, le);
            }else {
                le.damage(BattleSystemPlugin.getDamage(le)*((double)power)*0.2D, le);
            }
        }
    }

    @Override
    protected void update() {

    }
}
