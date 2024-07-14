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
    private boolean istarget = false;
    private boolean isowner = false;
    private boolean islocation = false;
    private boolean canclone = true;

    public SkillOwner() {

    }

    public boolean isCanClone() {
        return canclone;
    }

    public void setDontClone() {
        canclone = false;
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
        }else if(istarget) {
            loc = target.getLocation().add(0, 1.75, 0);
            islocation = true;
            return loc;
        }else if(isowner) {
            loc = owner.getLocation().add(0, 1.75, 0);
            islocation = true;
            return loc;
        }
        return null;
    }

    public void setDirection(Vector direction) {
        if(!islocation) {
            getLocation();
            if(!islocation) {
                return;
            }
        }
        loc.setDirection(direction);
    }

    public void resetDirection() {
        setDirection(Vector.getRandom());
    }

    @Override
    public SkillOwner clone() {
        SkillOwner skillowner = new SkillOwner();
        skillowner.owner = this.owner;
        skillowner.loc = this.loc!=null?this.loc.clone():null;
        skillowner.isowner = this.isowner;
        skillowner.islocation = this.islocation;
        return skillowner;
    }
}
