package simulation.entities.creatures;

import simulation.entities.Entity;
import simulation.entities.obstacles.Grass;
import simulation.worldmap.Coordinates;
import simulation.worldmap.WorldMap;

public class Herbivore extends Creature {

    @Override
    public void makeMove(Coordinates startCoordinates, Coordinates targetCoordinates, WorldMap worldMap){
        Entity entity = worldMap.getEntity(startCoordinates, worldMap);
        worldMap.removeEntity(startCoordinates, worldMap);
        //entity.findPath();
        //
        worldMap.setEntity(startCoordinates, entity, worldMap);
    }


    @Override
    public void eat() {

    }

}
