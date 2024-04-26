package taewookim.util;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

public class SkillOwner {

    private Entity owner;
    private double x;
    private double y;
    private double z;
    private double dx;
    private double dy;
    private double dz;
    private boolean isowner = false;
    private boolean islocation = false;
    private boolean isvector = false;

    public SkillOwner() {

    }

    public void setOwner(Entity entity) {
        this.owner = entity;
        isowner = true;
    }

    public void setLocation(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        islocation = true;
    }

    public boolean isLocation() {
        return islocation||isowner;
    }

    public double[] getLocation() {
        if(islocation) {
            return new double[]{x, y, z};
        }else if(isowner) {
            Location loc = owner.getLocation();
            return new double[]{loc.getX(), loc.getY(), loc.getZ()};
        }
        return null;
    }

    public void setDirection(double dx, double dy, double dz) {
        double deltasize = 1D/(Math.sqrt(dx*dx+dy*dy+dz*dz));
        this.dx = dx*deltasize;
        this.dy = dy*deltasize;
        this.dz = dz*deltasize;
    }

    public double[] getDiraction() {
        if(isvector) {
            return new double[]{dx, dy, dz};
        }else if(isowner) {
            Vector v = owner.getLocation().getDirection();
            return new double[]{v.getX(), v.getY(), v.getZ()};
        }
        Vector v = Vector.getRandom();
        return new double[]{v.getX(), v.getY(), v.getZ()};
    }

}
