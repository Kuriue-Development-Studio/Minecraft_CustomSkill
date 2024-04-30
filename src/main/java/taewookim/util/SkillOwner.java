package taewookim.util;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

public class SkillOwner {

    private LivingEntity target;
    private Entity owner;
    private double x;
    private double y;
    private double z;
    private double dx;
    private double dy;
    private double dz;
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

    public void setLocation(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        islocation = true;
    }

    public void resetLocation() {
        islocation = false;
    }

    public boolean isLocation() {
        return islocation||isowner||istarget;
    }

    public double[] getLocation() {
        if(islocation) {
            return new double[]{x, y, z};
        }else if(isowner) {
            Location loc = owner.getLocation();
            return new double[]{loc.getX(), loc.getY(), loc.getZ()};
        }else if(istarget) {
            Location loc = target.getLocation();
            return new double[]{loc.getX(), loc.getY(), loc.getZ()};
        }
        return null;
    }

    public void setDirection(double dx, double dy, double dz) {
        double deltasize = 1D/(Math.sqrt(dx*dx+dy*dy+dz*dz));
        this.dx = dx*deltasize;
        this.dy = dy*deltasize;
        this.dz = dz*deltasize;
        isvector = true;
    }

    public void resetDirection() {
        Vector v = Vector.getRandom();
        this.dx = v.getX();
        this.dy = v.getY();
        this.dz = v.getZ();
        isvector = true;
    }

    public double[] getDiraction() {
        if(isvector) {
            return new double[]{dx, dy, dz};
        }else if(isowner) {
            Vector v = owner.getLocation().getDirection();
            return new double[]{v.getX(), v.getY(), v.getZ()};
        }else if(istarget) {
            Vector v = target.getLocation().getDirection();
            return new double[]{v.getX(), v.getY(), v.getZ()};
        }
        Vector v = Vector.getRandom();
        return new double[]{v.getX(), v.getY(), v.getZ()};
    }

    @Override
    public SkillOwner clone() {
        SkillOwner skillowner = new SkillOwner();
        skillowner.owner = this.owner;
        skillowner.x = this.x;
        skillowner.y = this.y;
        skillowner.z = this.z;
        skillowner.dx = this.dx;
        skillowner.dy = this.dy;
        skillowner.dz = this.dz;
        skillowner.isowner = this.isowner;
        skillowner.islocation = this.islocation;
        skillowner.isvector = this.isvector;
        return skillowner;
    }
}
