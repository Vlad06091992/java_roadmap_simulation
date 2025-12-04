package simulation.entities;

import simulation.data.Utils;

public class AliveEntity extends Entity {
    protected Utils utils = new Utils();
    protected int health;
    protected int damage;

    public AliveEntity(String logo, int health, int damage) {
        super(logo);
        this.health = health;
        this.damage = damage;
    }

    public void beEaten(int damage) {
        this.health -= damage;
    }

    public void run() {

    }

    public int getHealth() {
        return health;
    }

}
