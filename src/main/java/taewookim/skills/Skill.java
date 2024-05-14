package taewookim.skills;

import org.bukkit.entity.LivingEntity;
import taewookim.CustomSkillPlugin;
import taewookim.util.ElementTypes;
import taewookim.util.SkillOwner;

public abstract class Skill {

    protected SkillOwner owner;
    protected int tick = 0;
    private boolean isend = false;
    private Skill nextskill;
    private final ElementTypes element;
    private final int power;

    public Skill(SkillOwner owner, ElementTypes element, int power) {
        this.element = element;
        this.power = power;
        this.owner = owner;
        if(!owner.isLocation()) {
            isend = true;
            return;
        }
        init(element, power);
    }

    public void replaceSkillOwner() {
        owner=owner.clone();
    }

    protected abstract void init(ElementTypes element, int power);

    protected abstract void update();

    public void setNextSkill(Skill nextSkill) {
        this.nextskill = nextSkill;
    }

    public boolean isEnd() {
        return isend;
    }

    @Override
    public Skill clone() {
        try{
            Skill skill = this.getClass().getDeclaredConstructor(SkillOwner.class, ElementTypes.class, int.class).newInstance(owner, element, power);
            skill.setNextSkill(nextskill.clone());
            return skill;
        }catch(Exception e) {
            return null;
        }
    }

    public final void gu() {
        tick--;
        if(isend) {
            return;
        }
        if(tick<1) {
            isend = true;
            if(nextskill!=null) {
                CustomSkillPlugin.plugin.addSkill(nextskill);
            }
            return;
        }
        update();
    }

}
