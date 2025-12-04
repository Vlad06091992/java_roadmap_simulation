package simulation;

import simulation.data.Field;
import simulation.data.Utils;
import simulation.data.Point;
import simulation.entities.AliveEntity;
import simulation.entities.Entity;
import simulation.entities.herbivores.Herbivore;
import simulation.entities.herbivores.entities.*;
import simulation.entities.predators.Predator;
import simulation.entities.predators.entities.*;
import simulation.entities.statics.Grass;
import simulation.entities.statics.Rock;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
//            new Tiger(),
//            new Wolf(),
//            new Fox(),
//            new Crocodile(),
            new Bear(),
            //травоядные

//            new Cow(),
//            new Sheep(),
//            new Rabbit(),
//            new Deer(),
            new Goat(),
            //трава
                 new Grass()
//            new Grass(),
//            new Grass(),
//            new Grass(),
    ));

    private static final Utils helpers = new Utils();


    public void run(int x,int y,int sleep) throws InterruptedException {
        init(x, y);
//        while (true) {
        for (;;) {
            Thread.sleep(sleep);
            action();
        }
    }

    public void  action() throws InterruptedException {
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

////        entitiesMap.clear();
//
//        //наносим их на карту
//        for (int i = 0; i < entities.size(); i++) {
//            Entity entity = entities.get(i);
////            entitiesMap.put(entity.getPoint(), entity);
//        }


        field.showMap(entitiesMap);

    }


    public  void init(int x, int y)  {

        field = new Field(x,y);

        // сущностей создали, надо сгенерировать им позиции
        for (int i = 0; i < entities.size(); i++) {
            Point currentPoint = new Point(helpers.getRandomInt(x, "x"), helpers.getRandomInt(y, "y"));
            Entity entity = entities.get(i);
            entity.setPoint(currentPoint);
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
