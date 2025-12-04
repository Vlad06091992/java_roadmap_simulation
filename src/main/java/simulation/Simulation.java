package simulation;

import simulation.data.Field;
import simulation.data.Point;
import simulation.data.Utils;
import simulation.entities.AliveEntity;
import simulation.entities.Entity;
import simulation.entities.herbivores.entities.*;
import simulation.entities.predators.entities.*;
import simulation.entities.statics.Grass;
import simulation.entities.statics.Rock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Simulation {

    private static Field field;
    private static final Map<Point, Entity> entitiesMap = new HashMap<>();
    private static ArrayList<Entity> entities = new ArrayList<>(Arrays.asList(

            //камни
            new Rock(),
            new Rock(),
            new Rock(),
            new Rock(),
            new Rock(),
            new Rock(),

            //хищники
            new Tiger(100,50),
            new Wolf(100,30),
            new Fox(100,20),
            new Crocodile(100,80),
            new Bear(100,100),
            //травоядные

            new Cow(600,40),
            new Sheep(200,30),
            new Rabbit(100,20),
            new Deer(800,70),
            new Goat(400,30),
            //трава
            new Grass(700),
            new Grass(800),
            new Grass(900),
            new Grass(1000)
    ));

    private static final Utils helpers = new Utils();


    public void run(int x, int y, int sleep) throws InterruptedException {
        init(x, y);
        for (; ; ) {
            Thread.sleep(sleep);
            action();
        }
    }

    public void action() throws InterruptedException {
        for (int i = 0; i < entities.size(); i++) {
            Entity entity = entities.get(i);
            if (entity instanceof AliveEntity) {
                if (((AliveEntity) entity).getHealth() <= 0) {
                    entities.remove(entity);
                    entitiesMap.remove(entity.getPoint());
                }
            }
        }

        //сущности меняют свои позиции
        for (int i = 0; i < entities.size(); i++) {
            Entity entity = entities.get(i);
            if (entity instanceof AliveEntity) {
                //по идее вот здесь сущности совершают ход, опираясь на старое состояние entitiesMap, чтобы не накладываться друг на друга
                ((AliveEntity) entity).run();
            }
        }

        field.showMap(entitiesMap);

    }


    public void init(int x, int y) {

        field = new Field(x, y);

        // сущностей создали, надо сгенерировать им позиции
        for (int i = 0; i < entities.size(); i++) {
//            Point currentPoint = new Point(helpers.getRandomInt(x, "x"), helpers.getRandomInt(y, "y"));
            Point point = helpers.getUniqRandomPoint(x);
            Entity entity = entities.get(i);
            entity.setPoint(point);
        }

        //наносим их на карту
        for (int i = 0; i < entities.size(); i++) {
            Entity entity = entities.get(i);
            entitiesMap.put(entity.getPoint(), entity);
        }

        // даем сущности доступ к полю с координатами других существ
        for (int i = 0; i < entities.size(); i++) {
            Entity entity = entities.get(i);
            entity.setEntitiesMap(entitiesMap);
            entity.setField(field);
        }

        field.showMap(entitiesMap);
    }


}
