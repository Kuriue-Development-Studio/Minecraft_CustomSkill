package taewookim.skills.cloneskill;

import org.bukkit.Location;
import taewookim.CustomSkillPlugin;
import taewookim.skills.Skill;
import taewookim.util.ElementTypes;
import taewookim.util.SkillOwner;

public class SkillShotGun extends Skill {
    public SkillShotGun(SkillOwner owner, ElementTypes element, int power) {
        super(owner, element, power);
    }

    @Override
    protected void init(ElementTypes element, int power) {
        if(owner.isCanClone()) {
            owner.setDontClone();
            for(int i = 0; i<power*2; i++) {
                Skill cloned = this.clone();
                cloned.replaceSkillOwner();
                Location loc = cloned.getOwner().getLocation();
                loc.setYaw(loc.getYaw()+CustomSkillPlugin.r.nextFloat()*10f-5f);
                loc.setPitch(loc.getPitch()+CustomSkillPlugin.r.nextFloat()*10f-5f);
                CustomSkillPlugin.plugin.addSkill(cloned);
            }
        }
    }

    @Override
    protected void update() {

    }
}
