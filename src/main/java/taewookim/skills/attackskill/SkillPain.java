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
                BattleSystemPlugin.Damage(le, owner.getTarget(), BattleSystemPlugin.getDamage(le)*((double)power)*0.2D);
            }else {
                BattleSystemPlugin.Damage(le, le, BattleSystemPlugin.getDamage(le)*((double)power)*0.2D);
            }
        }
    }

    @Override
    protected void update() {

    }
}
