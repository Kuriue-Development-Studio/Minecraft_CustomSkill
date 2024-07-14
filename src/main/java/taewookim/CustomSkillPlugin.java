package taewookim;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.checkerframework.checker.units.qual.N;
import taewookim.commands.SkillItemCommand;
import taewookim.commands.SkillMakerCommand;
import taewookim.skills.Skill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CustomSkillPlugin extends JavaPlugin {

    public static CustomSkillPlugin plugin;
    private ArrayList<Skill> skills = new ArrayList<>();
    private ArrayList<Skill> adding = new ArrayList<>();
    private boolean isupdating = false;
    public static Random r = new Random();

    public static NamespacedKey itemskill;
    public static Map<Integer, NamespacedKey> skilltypes = new HashMap<>();
    public static Map<Integer, NamespacedKey> elementtypes = new HashMap<>();
    public static Map<Integer, NamespacedKey> powertypes = new HashMap<>();

    private void loadNameSpaceKeys() {
        itemskill = new NamespacedKey(this, "SkillItem");
        for(int i = 0; i<10; i++) {
            skilltypes.put(i, new NamespacedKey(this, "SkillType"+i));
            elementtypes.put(i, new NamespacedKey(this, "ElementType"+i));
            powertypes.put(i, new NamespacedKey(this, "PowerType"+i));
        }
    }

    public void addSkill(Skill skill) {
        if(isupdating) {
            adding.add(skill);
        }else {
            skills.add(skill);
        }
    }

    private void startUpdate() {
        BukkitRunnable brun = new BukkitRunnable() {
            @Override
            public void run() {
                ArrayList<Skill> removing = new ArrayList<>(skills.size());
                isupdating = true;
                for(Skill skill : skills) {
                    skill.gu();
                    if(skill.isEnd()) {
                        removing.add(skill);
                    }
                }
                isupdating = false;
                skills.removeAll(removing);
                skills.addAll(adding);
                adding.clear();
            }
        };brun.runTaskTimer(this, 0, 0);
    }

    @Override
    public void onEnable() {
        plugin = this;
        loadNameSpaceKeys();
        startUpdate();
        SkillMakerCommand cmd = new SkillMakerCommand();
        Bukkit.getPluginCommand("skillmaker").setExecutor(cmd);
        Bukkit.getPluginCommand("skillmaker").setTabCompleter(cmd);
        SkillItemCommand cmd1 = new SkillItemCommand();
        Bukkit.getPluginCommand("skillitem").setExecutor(cmd1);
        Bukkit.getPluginCommand("skillitem").setTabCompleter(cmd1);
    }

}
