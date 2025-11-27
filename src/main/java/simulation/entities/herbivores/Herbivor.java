package simulation.entities.herbivores;

import simulation.data.Helpers;
import simulation.data.Point;
import simulation.entities.Animal;
import simulation.entities.Entity;
import simulation.entities.statics.Grass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Herbivor extends Animal {

    Helpers helpers = new Helpers();

    public Herbivor(String logo) {
        super(logo);
    }

    public Point findNearestGrass() {

        Integer min = 1000;

        Map<Integer, Entity> grassPoints = new HashMap();

        Map<Point, Entity> entitiesMap = super.getEntitiesMap();

        for (Entity entity : entitiesMap.values()) {
            if (entity instanceof Grass) {
                int value = helpers.findPathLength(super.getPoint(), entity.getPoint());
                grassPoints.put(value, entity);
                if (value < min) {
                    min = value;
                }
            }

        }
        Point target = grassPoints.get(min).getPoint();

        return target;

    }

    @Override
    public void run() {

        Point point = super.getPoint();
        Point target = findNearestGrass();

//        List<Point> points = helpers.generateCoordinates(point, target);
        Point nextPoint = helpers.generateNextStepCoordinates(point, target);
        int pathLength = helpers.findPathLength(point, target);
        if (pathLength == 0) {
            return;
        } else {
            super.setPoint(nextPoint);
        }
    }


}
