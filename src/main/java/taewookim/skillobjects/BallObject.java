package taewookim.skillobjects;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import taewookim.hitbox.HitBox;
import taewookim.hitbox.type.AttackBox;

public class BallObject extends HitBox implements AttackBox {
    public BallObject(Location mainloc, LivingEntity owner) {
        super(mainloc, owner);
    }

    @Override
    protected void enterHitBox(Entity entity) {

    }

    @Override
    protected void quitHitBox(Entity entity) {

    }

    @Override
    protected void collisionHitBox(HitBox hitBox) {

    }

    @Override
    public void update() {
        super.update();
    }
}
