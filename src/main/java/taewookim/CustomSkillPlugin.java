package taewookim;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import taewookim.skills.Skill;

import java.util.ArrayList;

public class CustomSkillPlugin extends JavaPlugin {

    public static CustomSkillPlugin plugin;
    private ArrayList<Skill> skills = new ArrayList<>();
    private ArrayList<Skill> adding = new ArrayList<>();
    private boolean isupdating = false;

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
        startUpdate();
    }

}
