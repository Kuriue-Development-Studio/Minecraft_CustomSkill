package taewookim.util;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import taewookim.CustomSkillPlugin;
import taewookim.skills.Skill;

import java.util.ArrayList;

public class SkillItemBuilder {

    private final ArrayList<SkillTypes> skills;
    private final ArrayList<ElementTypes> elements;
    private final ArrayList<Integer> powers;

    public SkillItemBuilder() {
        skills = new ArrayList<>();
        elements = new ArrayList<>();
        powers = new ArrayList<>();
    }

    public SkillItemBuilder(int skillcount) {
        skills = new ArrayList<>(skillcount);
        elements = new ArrayList<>(skillcount);
        powers = new ArrayList<>(skillcount);
    }

    public void addSkill(SkillTypes skilltype, ElementTypes elementType, int power) {
        skills.add(skilltype);
        elements.add(elementType);
        powers.add(power);
    }

    public ItemStack build() {
        ItemStack i = new ItemStack(Material.BOOK);
        ItemMeta m = i.getItemMeta();
        m.setDisplayName("§a미지의 스킬북");
        PersistentDataContainer container = m.getPersistentDataContainer();
        int size = skills.size();
        if(size>10) {
            size = 10;
        }
        container.set(CustomSkillPlugin.itemskill, PersistentDataType.INTEGER, size);
        for(int j = 0; j<size; j++) {
            container.set(CustomSkillPlugin.skilltypes.get(j)
                    , PersistentDataType.STRING, skills.get(j).toString());
            container.set(CustomSkillPlugin.elementtypes.get(j)
                    , PersistentDataType.STRING, elements.get(j).toString());
            container.set(CustomSkillPlugin.powertypes.get(j)
                    , PersistentDataType.INTEGER, powers.get(j));
        }
        i.setItemMeta(m);
        return i;
    }

}
