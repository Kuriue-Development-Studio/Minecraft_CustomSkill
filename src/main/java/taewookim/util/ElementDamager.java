package taewookim.util;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

public abstract class ElementDamager {

    public abstract void entityDamage(LivingEntity damager, LivingEntity target, int power);

}
