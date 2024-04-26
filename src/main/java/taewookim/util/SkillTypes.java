package taewookim.util;

import taewookim.elements.Element;
import taewookim.skills.Skill;

public enum SkillTypes {

    SKILL(Skill.class);

    private final Class<? extends Skill> clz;

    SkillTypes(Class<Skill> clz) {
        this.clz = clz;
    }

    public Skill create(SkillOwner owner, Element element, int power) {
        try{
            return clz.getDeclaredConstructor(SkillOwner.class, Element.class, int.class).newInstance(owner, element, power);
        }catch(Exception e) {
            return null;
        }
    }

}
