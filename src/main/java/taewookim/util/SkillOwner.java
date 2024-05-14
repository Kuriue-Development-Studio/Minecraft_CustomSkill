package taewookim.util;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

public class SkillOwner {

    private LivingEntity target;
    private Entity owner;
    private Location loc;
    private Vector direction;
    private boolean istarget = false;
    private boolean isowner = false;
    private boolean islocation = false;
    private boolean isvector = false;

    public SkillOwner() {

    }

    public void setTarget(LivingEntity target) {
        this.target = target;
        istarget = true;
    }

    public void resetTarget() {
        target = null;
        istarget = false;
    }

    public boolean isTarget() {
        return istarget;
    }

    public LivingEntity getTarget() {
        return target;
    }

    public void setOwner(Entity entity) {
        this.owner = entity;
        isowner = true;
    }

    public void resetOwner() {
        owner = null;
        isowner = false;
    }

    public boolean isOwner() {
        return isowner;
    }

    public Entity getOwner() {
        return owner;
    }

    public void setLocation(Location loc) {
        this.loc = loc;
        islocation = true;
    }

    public void resetLocation() {
        islocation = false;
    }

    public boolean isLocation() {
        return islocation||isowner||istarget;
    }

    public Location getLocation() {
        if(islocation) {
            return loc;
        }else if(isowner) {
            return owner.getLocation();
        }else if(istarget) {
            return target.getLocation();
        }
        return null;
    }

    public void setDirection(Vector direction) {
        this.direction = direction;
        isvector = true;
    }

    public void resetDirection() {
        direction = Vector.getRandom();
        isvector = true;
    }

    public Vector getDiraction() {
        if(isvector) {
            return direction;
        }else if(isowner) {
            return owner.getLocation().getDirection();
        }else if(istarget) {
            return target.getLocation().getDirection();
        }
        return Vector.getRandom();
    }

    @Override
    public SkillOwner clone() {
        SkillOwner skillowner = new SkillOwner();
        skillowner.owner = this.owner;
        skillowner.loc = this.loc.clone();
        skillowner.direction = this.direction.clone();
        skillowner.isowner = this.isowner;
        skillowner.islocation = this.islocation;
        skillowner.isvector = this.isvector;
        return skillowner;
    }
}
