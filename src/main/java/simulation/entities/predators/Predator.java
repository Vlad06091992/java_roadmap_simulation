package simulation.entities.predators;

import simulation.Helpers;
import simulation.Point;
import simulation.entities.Entity;
import simulation.entities.herbivores.Herbivor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Predator extends Entity {

    Helpers helpers = new Helpers();

    public void run() {

        Point point = super.getPoint();
        Point target = findNearestHerbivore();

        List<Point> points = helpers.generateCoordinates(point, target);
        System.out.println(points);
        super.setPoint(points.get(0));
//        System.out.println();

    }

    public Predator(String logo) {
        super(logo);
    }


    public Point findNearestHerbivore() {

        Integer min = 1000;

        Map<Integer, Entity> herbivorePoints = new HashMap();

        Map<Point, Entity> entitiesMap = super.getEntitiesMap();

        for (Entity entity : entitiesMap.values()) {
            if (!(entity instanceof Predator)) {
                int value = helpers.findPathLength(super.getPoint(), entity.getPoint());
                herbivorePoints.put(value, entity);
                if (value < min) {
                    min = value;
                }
            }

        }
        Point target = herbivorePoints.get(min).getPoint();
        System.out.println(target.toString());

        return target;

    }
}


