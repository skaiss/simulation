package simulation.entities.creatures;

import simulation.entities.Entity;
import simulation.worldmap.Coordinates;
import simulation.worldmap.WorldMap;

public class Predator extends Creature {

    @Override
    public void makeMove(Coordinates startCoordinates, Coordinates targetCoordinates, WorldMap worldMap){

        Entity entity = worldMap.getEntity(startCoordinates, worldMap);
        worldMap.removeEntity(startCoordinates, worldMap);
        worldMap.setEntity(targetCoordinates, entity, worldMap);
    }


    public void attack(){

    }

    @Override
    public void eat() {

    }


}
