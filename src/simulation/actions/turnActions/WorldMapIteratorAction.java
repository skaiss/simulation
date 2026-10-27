package simulation.actions.turnActions;

import simulation.entities.Entity;
import simulation.entities.creatures.Creature;
import simulation.entities.creatures.Herbivore;
import simulation.search.BreadthFirstSearch;
import simulation.worldmap.Coordinates;
import simulation.worldmap.WorldMap;

import java.util.*;

public class WorldMapIteratorAction {

    BreadthFirstSearch pathFinder = new BreadthFirstSearch();

//    public void iterateWorldMap(WorldMap worldMap) {
//        int mapHeight = worldMap.getWorldMapHeight();
//        int mapWidth = worldMap.getWorldMapWidth();
//
//        for (int row = 0; row < mapHeight; row++) {
//            for (int column = 0; column < mapWidth; column++) {
//                Coordinates coordinates = new Coordinates(column, row);
//
//                if(isCreature(coordinates, worldMap)) {
//                    Creature creature = (Creature) worldMap.getEntity(coordinates, worldMap);
//                    path = pathFinder.findPath(coordinates, worldMap);
//                    Coordinates move = path.getFirst();
//                    creature.makeMove(coordinates, move, worldMap);
//                }
//            }
//        }
//    }


    public void iterateWorldMap(WorldMap worldMap){
        HashMap<Creature, Coordinates> creatures = worldMap.makeMap();
        for (Map.Entry<Creature, Coordinates> entry : creatures.entrySet()) {
            Creature creature = entry.getKey();
            Coordinates coordinates = entry.getValue();
            List<Coordinates> path = pathFinder.findPath(coordinates, worldMap);
            if(!path.isEmpty()) {
                Coordinates move = path.get(0);

                    creature.makeMove(coordinates, move, worldMap);


            }
        }
    }
    // обход creatures and add method list of moves


    public boolean isCreature(Coordinates coordinates, WorldMap worldMap){
        Entity entity = worldMap.getEntity(coordinates, worldMap);
        return entity instanceof Creature;
    }



}
