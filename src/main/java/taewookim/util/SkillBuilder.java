package taewookim.util;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
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

    public SkillBuilder(ItemStack i) {
        if(!i.hasItemMeta()) {
            skills = new ArrayList<>();
            elements = new ArrayList<>();
            powers = new ArrayList<>();
            return;
        }
        PersistentDataContainer container = i.getItemMeta().getPersistentDataContainer();
        int size = 0;
        if(container.has(CustomSkillPlugin.itemskill, PersistentDataType.INTEGER)) {
            size = container.get(CustomSkillPlugin.itemskill, PersistentDataType.INTEGER);
        }
        skills = new ArrayList<>(size);
        elements = new ArrayList<>(size);
        powers = new ArrayList<>(size);
        for(int j = 0; j<size; j++) {
            skills.add(SkillTypes.valueOf(container.get(CustomSkillPlugin.skilltypes.get(j), PersistentDataType.STRING)));
            elements.add(ElementTypes.valueOf(container.get(CustomSkillPlugin.elementtypes.get(j), PersistentDataType.STRING)));
            powers.add(container.get(CustomSkillPlugin.powertypes.get(j), PersistentDataType.INTEGER));
        }
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
        if(firstskill==null) {
            return;
        }
        Skill lastskill = firstskill;
        for(int i = 1; i<skills.size(); i++) {
            Skill newskill = skills.get(i).create(owner, elements.get(i), powers.get(i));
            if(newskill!=null) {
                lastskill.setNextSkill(newskill);
                lastskill = newskill;
            }
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
