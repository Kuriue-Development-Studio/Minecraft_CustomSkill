package taewookim.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import taewookim.util.ElementTypes;
import taewookim.util.SkillBuilder;
import taewookim.util.SkillItemBuilder;
import taewookim.util.SkillTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SkillItemCommand implements CommandExecutor, TabCompleter {

    private final List<String> skilltypes;
    private final List<String> elementtypes;
    private final List<String> powers = Arrays.asList("1", "2", "3", "4", "5");
    private final List<String> none = Arrays.asList();

    public SkillItemCommand() {
        SkillTypes[] types = SkillTypes.values();
        skilltypes = new ArrayList<>(types.length);
        for(SkillTypes type : types) {
            skilltypes.add(type.toString());
        }
        ElementTypes[] types1 = ElementTypes.values();
        elementtypes = new ArrayList<>(types1.length);
        for(ElementTypes type : types1) {
            elementtypes.add(type.toString());
        }
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        SkillItemBuilder builder = new SkillItemBuilder(strings.length);
        for(String line : strings) {
            String[] values = line.split(":");
            builder.addSkill(SkillTypes.valueOf(values[0]), ElementTypes.valueOf(values[1]), Integer.parseInt(values[2]));
        }
        if(commandSender instanceof Player p) {
            p.getInventory().addItem(builder.build());
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        switch((int) strings[strings.length-1].chars().filter(c-> c==':').count()) {
            case 0:
                return skilltypes;
            case 1:
                return elementtypes;
            case 2:
                return powers;
            default:
                return none;
        }
    }
}
