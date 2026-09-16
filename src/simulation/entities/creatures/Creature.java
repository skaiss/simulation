package simulation.entities.creatures;

import simulation.entities.Entity;
import simulation.worldmap.Coordinates;
import simulation.worldmap.WorldMap;

public abstract class Creature extends Entity {

    public abstract void makeMove(Coordinates startCoordinates, Coordinates targetCoordinates, WorldMap worldMap);

    public abstract void eat();

    //take damage




}
