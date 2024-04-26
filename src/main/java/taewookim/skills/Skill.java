package taewookim.skills;

import org.bukkit.entity.LivingEntity;
import taewookim.CustomSkillPlugin;
import taewookim.util.ElementTypes;
import taewookim.util.SkillOwner;

public abstract class Skill {

    protected SkillOwner owner;
    private int tick = 0;
    private boolean isend = false;
    private Skill nextskill;
    private final ElementTypes element;
    private final int power;

    public Skill(SkillOwner owner, ElementTypes element, int power) {
        this.element = element;
        this.power = power;
        this.owner = owner;
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

    /*@Override
    public Skill clone() {
        try{
            Skill skill = this.getClass().getDeclaredConstructor(SkillOwner.class, ElementTypes.class, int.class).newInstance(owner, element, power);

            return skill;
        }catch(Exception e) {
        }
    }*/

    public final void gu() {
        tick--;
        if(tick<1) {
            isend = true;
            CustomSkillPlugin.plugin.addSkill(nextskill);
            return;
        }
        update();
    }

}
