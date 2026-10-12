package simulation.actions.initActions;

import simulation.actions.Actions;
import simulation.entities.EntityFactory;
import simulation.worldmap.Coordinates;
import simulation.worldmap.WorldMap;

import java.util.Random;

import static simulation.entities.EntityType.*;
import static simulation.entities.EntityType.ROCK;
import static simulation.entities.EntityType.TREE;

public class SpawnAction extends Actions {

    private final Random random = new Random();
    private final EntityFactory entityFactory = new EntityFactory();

    @Override
    public void execute(WorldMap worldMap) {
            for (int row = 0; row < worldMap.getWorldMapHeight(); row++) {
                for (int column = 0; column < worldMap.getWorldMapWidth(); column++) {
                    Coordinates coordinates = new Coordinates(column, row);

                    int randomNumber = random.nextInt(101);
                    if (randomNumber < 5) {
                        worldMap.setEntity(coordinates,entityFactory.createEntity(HERBIVORE), worldMap);
                    }
//                    else if(randomNumber >= 5 && randomNumber < 10){
//                        worldMap.setEntity(coordinates,entityFactory.createEntity(PREDATOR),worldMap);
//                    }
                    else if(randomNumber >= 10 && randomNumber < 20){
                        worldMap.setEntity(coordinates,entityFactory.createEntity(GRASS),worldMap);
                    }
                    else if(randomNumber >= 20 && randomNumber < 30){
                        worldMap.setEntity(coordinates,entityFactory.createEntity(ROCK), worldMap);
                    }
                    else if(randomNumber >= 30 && randomNumber < 35){
                        worldMap.setEntity(coordinates,entityFactory.createEntity(TREE), worldMap);
                    }
                }
            }
    }
}
