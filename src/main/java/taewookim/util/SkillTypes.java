package taewookim.util;

import taewookim.skills.Skill;
import taewookim.skills.attackskill.SkillLazer;
import taewookim.skills.attackskill.SkillPain;
import taewookim.skills.moveskill.SkillJump;
import taewookim.skills.utilskill.SkillTarget;
import taewookim.skills.utilskill.SkillTargetMe;
import taewookim.skills.utilskill.SkillUP;

public enum SkillTypes {

    SKILL(Skill.class),
    SKILL_TARGET(SkillTarget.class),
    SKILL_PAIN(SkillPain.class),
    SKILL_TARGET_ME(SkillTargetMe.class),
    SKILL_JUMP(SkillJump.class),
    SKILL_LAZER(SkillLazer.class),
    SKILL_UP(SkillUP.class),
    ;

    private final Class<? extends Skill> clz;

    SkillTypes(Class<? extends Skill> clz) {
        this.clz = clz;
    }

    public Skill create(SkillOwner owner, ElementTypes element, int power) {
        try{
            return clz.getDeclaredConstructor(SkillOwner.class, ElementTypes.class, int.class).newInstance(owner, element, power);
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
