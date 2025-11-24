package simulation.entities;



import simulation.Point;

public abstract class Entity {
    private Point point;
    private String logo;

    public Entity(String logo) {
        this.logo = logo;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }


    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

}
