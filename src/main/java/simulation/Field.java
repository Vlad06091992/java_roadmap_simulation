package simulation;

import simulation.entities.Entity;
import simulation.entities.herbivores.*;
import simulation.entities.predators.*;

import java.util.*;

public class Field {
    private final List<Point> points = new ArrayList<>();
    private final Map<Point, Entity> objects = new HashMap<>();
    int x;
    int y;
    Set<Integer> xSet = new HashSet<>();
    Set<Integer> ySet = new HashSet<>();

    private void generateStartCooridinates() {
        objects.put(new Point(getRandomInt(x, "x"), getRandomInt(y, "y")), new Tiger());
        objects.put(new Point(getRandomInt(x, "x"), getRandomInt(y, "y")), new Wolf());
        objects.put(new Point(getRandomInt(x, "x"), getRandomInt(y, "y")), new Fox());
        objects.put(new Point(getRandomInt(x, "x"), getRandomInt(y, "y")), new Crocodile());
        objects.put(new Point(getRandomInt(x, "x"), getRandomInt(y, "y")), new Bear());

        objects.put(new Point(getRandomInt(x, "x"), getRandomInt(y, "y")), new Rabbit());
        objects.put(new Point(getRandomInt(x, "x"), getRandomInt(y, "y")), new Cow());
        objects.put(new Point(getRandomInt(x, "x"), getRandomInt(y, "y")), new Deer());
        objects.put(new Point(getRandomInt(x, "x"), getRandomInt(y, "y")), new Sheep());
        objects.put(new Point(getRandomInt(x, "x"), getRandomInt(y, "y")), new Goat());
//        objects.put(new Point(3, 5), new Wolf());
//        objects.put(new Point(1, 6), new Fox());
//        objects.put(new Point(4, 3), new Crocodile());
//        objects.put(new Point(7, 9), new Bear());
////
//        objects.put(new Point(8, 2), new Rabbit());
//        objects.put(new Point(6, 3), new Cow());
//        objects.put(new Point(4, 4), new Deer());
//        objects.put(new Point(2, 3), new Sheep());
//        objects.put(new Point(7, 4), new Goat());

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                points.add(new Point(j, i));
            }
        }

    }

    public Field(int x, int y) {
        this.x = x;
        this.y = y;

        generateStartCooridinates();

    }

//    private Integer getRandomInt(Integer to, String type) {
//        Set targetSet = type == "x" ? xSet : ySet;
//
//
//        Integer result;
//        do {
//            result = new Random().nextInt(to);
//            targetSet.add(result);
//        } while (!targetSet.contains(result)); {
//            result = new Random().nextInt(to);
//            targetSet.add(result);
//        }
//
//        return result;
//    }

    private Integer getRandomInt(Integer to, String type) {
        Set<Integer> targetSet = "x".equals(type) ? xSet : ySet;
        Random random = new Random();

        Integer result;
        do {
            result = random.nextInt(to);
        } while (targetSet.contains(result)); // Генерируем, пока не найдем уникальное

        targetSet.add(result);
        return result;
    }

    public void showMap() {

        String field = "";
        for (int i = 0; i < points.size(); i++) {

            String end = (i + 1) % x == 0 ? "\n" : " ";


            Point point = points.get(i);
            if (objects.containsKey(point)) {
                field += objects.get(point).getLogo() + end;
                System.out.println(point.getCoordinates());
            } else {
                field += points.get(i).toString() + end;
            }


        }

        System.out.println(field);
    }

}
