package taewookim.util;

import taewookim.CustomSkillPlugin;
import taewookim.skills.Skill;

import java.util.ArrayList;

public class SkillBuilder {

    private final ArrayList<Skill> skills;

    public SkillBuilder() {
        skills = new ArrayList<>();
    }

    public SkillBuilder(int skillcount) {
        skills = new ArrayList<>(skillcount);
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public void build() {
        if(skills.isEmpty()) {
            return;
        }
        for(int i = 0; i<skills.size()-1; i++) {
            skills.get(i).setNextSkill(skills.get(i+1));
        }
        CustomSkillPlugin.plugin.addSkill(skills.get(0));
    }

}
