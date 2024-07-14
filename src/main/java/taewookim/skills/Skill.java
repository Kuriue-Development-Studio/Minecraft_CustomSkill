package taewookim.skills;

import org.bukkit.entity.LivingEntity;
import taewookim.CustomSkillPlugin;
import taewookim.util.ElementTypes;
import taewookim.util.SkillOwner;

public abstract class Skill {

    protected SkillOwner owner;
    protected int tick = 0;
    protected final ElementTypes element;
    protected final int power;
    private boolean isend = false;
    private boolean firstupdate = false;
    private Skill nextskill = null;

    public Skill(SkillOwner owner, ElementTypes element, int power) {
        this.element = element;
        this.power = power;
        this.owner = owner;
        if(!owner.isLocation()) {
            isend = true;
        }
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

    protected void setEnd() {
        isend = true;
    }

    @Override
    public Skill clone() {
        try{
            Skill skill = this.getClass().getConstructor(SkillOwner.class, ElementTypes.class, int.class).newInstance(owner, element, power);
            if(nextskill!=null) {
                skill.setNextSkill(nextskill.clone());
            }
            return skill;
        }catch(Exception e) {
            return null;
        }
    }

    public SkillOwner getOwner() {
        return owner;
    }

    public final void gu() {
        tick--;
        if(isend) {
            return;
        }
        if(!firstupdate) {
            init(element, power);
            firstupdate=true;
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
