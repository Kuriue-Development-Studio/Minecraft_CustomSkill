package taewookim.skills;

import org.bukkit.entity.LivingEntity;
import taewookim.CustomSkillPlugin;
import taewookim.elements.Element;
import taewookim.util.SkillOwner;

public abstract class Skill {

    protected final SkillOwner owner;
    private int tick = 0;
    private boolean isend = false;
    private Skill nextskill;
    private final Element element;
    private final int power;

    public Skill(SkillOwner owner, Element element, int power) {
        this.element = element;
        this.power = power;
        this.owner = owner;
        init(element, power);
    }

    protected abstract void init(Element element, int power);

    protected abstract void update();

    public void setNextSkill(Skill nextSkill) {
        this.nextskill = nextSkill;
    }

    public boolean isEnd() {
        return isend;
    }

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
