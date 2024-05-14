package taewookim.util;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import taewookim.CustomSkillPlugin;
import taewookim.skills.Skill;

import java.util.ArrayList;

public class SkillBuilder {

    private final ArrayList<SkillTypes> skills;
    private final ArrayList<ElementTypes> elements;
    private final ArrayList<Integer> powers;

    public SkillBuilder() {
        skills = new ArrayList<>();
        elements = new ArrayList<>();
        powers = new ArrayList<>();
    }

    public SkillBuilder(int skillcount) {
        skills = new ArrayList<>(skillcount);
        elements = new ArrayList<>(skillcount);
        powers = new ArrayList<>(skillcount);
    }

    public void addSkill(SkillTypes skilltype, ElementTypes elementType, int power) {
        skills.add(skilltype);
        elements.add(elementType);
        powers.add(power);
    }

    public void build(SkillOwner owner) {
        if(skills.isEmpty()) {
            return;
        }
        Skill firstskill = skills.get(0).create(owner, elements.get(0), powers.get(0));
        Skill lastskill = firstskill;
        for(int i = 1; i<skills.size(); i++) {
            Skill newskill = skills.get(i).create(owner, elements.get(i), powers.get(i));
            lastskill.setNextSkill(newskill);
            lastskill = newskill;
        }
        CustomSkillPlugin.plugin.addSkill(firstskill);
    }

    public void build(Player p) {
        SkillOwner owner = new SkillOwner();
        owner.setOwner(p);
        build(owner);
    }

    public void build(Location loc) {
        SkillOwner owner = new SkillOwner();
        owner.setLocation(loc);
        build(owner);
    }

}
