package simulation.actions.turnActions;

import simulation.entities.Entity;
import simulation.entities.creatures.Creature;
import simulation.search.BreadthFirstSearch;
import simulation.worldmap.Coordinates;
import simulation.worldmap.CoordinatesUtils;
import simulation.worldmap.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class WorldMapIteratorAction {

    BreadthFirstSearch pathFinder = new BreadthFirstSearch();
    List<Coordinates> result = new ArrayList<>();

    public void iterateWorldMap(WorldMap worldMap) {
        int mapHeight = worldMap.getWorldMapHeight();
        int mapWidth = worldMap.getWorldMapWidth();

        for (int row = 0; row < mapHeight; row++) {
            for (int column = 0; column < mapWidth; column++) {
                Coordinates coordinates = new Coordinates(column, row);

                if(isCreature(coordinates, worldMap)) {
                    Creature creature = (Creature) worldMap.getEntity(coordinates, worldMap);
                    result = pathFinder.findPath(coordinates, worldMap);

                }
            }
        }
    }


    public boolean isCreature(Coordinates coordinates, WorldMap worldMap){
        Entity entity = worldMap.getEntity(coordinates, worldMap);
        return entity instanceof Creature;
    }



}
