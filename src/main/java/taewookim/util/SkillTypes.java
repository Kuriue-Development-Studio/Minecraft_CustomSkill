package taewookim.util;

import taewookim.skills.Skill;

public enum SkillTypes {

    SKILL(Skill.class);

    private final Class<? extends Skill> clz;

    SkillTypes(Class<Skill> clz) {
        this.clz = clz;
    }

    public Skill create(SkillOwner owner, ElementTypes element, int power) {
        try{
            return clz.getDeclaredConstructor(SkillOwner.class, ElementTypes.class, int.class).newInstance(owner, element, power);
        }catch(Exception e) {
            return null;
        }
    }

}
