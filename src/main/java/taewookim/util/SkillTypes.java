package taewookim.util;

import taewookim.skills.Skill;
import taewookim.skills.attackskill.*;
import taewookim.skills.cloneskill.SkillShotGun;
import taewookim.skills.moveskill.SkillJump;
import taewookim.skills.utilskill.*;

public enum SkillTypes {

    SKILL(Skill.class),
    SKILL_TARGET(SkillTarget.class),
    SKILL_PAIN(SkillPain.class),
    SKILL_TARGET_ME(SkillTargetMe.class),
    SKILL_JUMP(SkillJump.class),
    SKILL_LAZER(SkillLazer.class),
    SKILL_UP(SkillUP.class),
    SKILL_EXPLOSION(SkillExplosion.class),
    SKILL_BALL(SkillBall.class),
    SKILL_RANDOM_DIRECTION(SkillRandomDirection.class),
    SKILL_RANDOM_POSITION(SkillRandomPosition.class),
    SKILL_PROJECTILE(SkillProjectile.class),
    SKILL_SHOTGUN(SkillShotGun.class),
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
