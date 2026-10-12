package simulation.worldmap;

import simulation.entities.Entity;
import simulation.entities.obstacles.Rock;
import simulation.entities.obstacles.Tree;

import java.util.ArrayList;
import java.util.List;
//import java.util.Random;

public class CoordinatesUtils {

//    private final static Random random = new Random();

//    public static Coordinates getRandomCoordinates(WorldMap worldMap) {
//          while (true) {
//              int x = random.nextInt(worldMap.getWorldMapWidth());
//              int y = random.nextInt(worldMap.getWorldMapHeight());
//              Coordinates coordinates = new Coordinates(x,y);
//              if (CoordinatesUtils.isCellEmpty(coordinates, worldMap)) {
//                  return coordinates;
//              }
//          }
//      }

    public static List<Coordinates> getCloseCells(Coordinates coordinates){
        List<Coordinates> result = new ArrayList<>();

        result.add(new Coordinates(coordinates.x() + 1, coordinates.y()));
        result.add(new Coordinates(coordinates.x() - 1, coordinates.y()));

        result.add(new Coordinates(coordinates.x(),coordinates.y() + 1));
        result.add(new Coordinates(coordinates.x(), coordinates.y() - 1));

        return result;
    }

    public static void validateCoordinates(Coordinates coordinates, WorldMap worldMap){
        if(coordinates == null){
            throw new IllegalArgumentException("coordinates are null");
        } else if (!isInBounds(coordinates, worldMap)){
            throw new IllegalArgumentException("coordinates out of bounds");
        }
    }

    public static boolean isInBounds(Coordinates coordinates, WorldMap worldMap){
        return  coordinates.x() >= 0 && coordinates.x() < worldMap.getWorldMapWidth() &&
                coordinates.y() >= 0 && coordinates.y() < worldMap.getWorldMapHeight();
    }

    public static boolean isCellEmpty(Coordinates coordinates, WorldMap worldMap){
       // validateCoordinates(coordinates, worldMap);
        return !worldMap.getEntities().containsKey(coordinates);
    }

    public static boolean isObstacle(Coordinates coordinates, WorldMap worldMap) {
        Entity entity =  worldMap.getEntity(coordinates, worldMap);
        return entity instanceof Rock || entity instanceof Tree;
    }




    }


